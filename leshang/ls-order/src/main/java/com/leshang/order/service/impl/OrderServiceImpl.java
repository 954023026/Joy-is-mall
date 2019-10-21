package com.leshang.order.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.leshang.common.dto.CartDto;
import com.leshang.common.enums.ExceptionEnum;
import com.leshang.common.exception.LyException;
import com.leshang.common.pojo.UserInfo;
import com.leshang.common.utils.IdWorker;
import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.order.client.AddressClient;
import com.leshang.order.client.ItemClinet;
import com.leshang.order.dto.AddressDTO;
import com.leshang.order.dto.OrderDto;
import com.leshang.order.enums.OrderStatusEnum;
import com.leshang.order.interceptors.PayState;
import com.leshang.order.interceptors.UserInterceptor;
import com.leshang.order.mapper.OrderDetailMapper;
import com.leshang.order.mapper.OrderMapper;
import com.leshang.order.mapper.OrderStatusMapper;
import com.leshang.order.pojo.Order;
import com.leshang.order.pojo.OrderDetail;
import com.leshang.order.pojo.OrderStatus;
import com.leshang.order.service.OrderService;
import com.leshang.order.utils.PayHelper;
import com.leshang.order.vo.OrderVo;
import com.leshang.user.pojo.ZkUserAddress;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-21 11:36
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper detailMapper;
    @Autowired
    private OrderStatusMapper statusMapper;
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private ItemClinet itemClinet;
    @Autowired
    public PayHelper payHelper;
    @Autowired
    private AddressClient addressClient;

    @Override
    @Transactional
    public Long createOrder(OrderDto orderDto) {
        //1.新增订单
        Order order = new Order();
        //1.1 订单编号，基本信息
        long orderId = idWorker.nextId();
        order.setOrderId(orderId);
        order.setCreateTime(new Date());
        order.setPaymentType(orderDto.getPaymentType());
        //1.2 用户信息
        UserInfo user = UserInterceptor.getUser();
        order.setUserId(user.getId());
        order.setBuyerNick(user.getUsername());
        order.setBuyerRate(false);

        //1.3 收货人地址
        //todo 收货地址
        ZkUserAddress addr = addressClient.queryAddressByAddressId(orderDto.getAddressId());
        order.setReceiver(addr.getRealname());
        order.setReceiverAddress(addr.getStreet());
        order.setReceiverCity(addr.getCity());
        order.setReceiverDistrict(addr.getArea());
        order.setReceiverMobile(addr.getTelphone());
        order.setReceiverState(addr.getProvince());
        //1.4 金额
        //把cartdto转为一个map，key 是sku的id，值是num
        Map<Long, Integer> numMap = orderDto.getCarts()
                .stream().collect(Collectors.toMap(CartDto::getId, CartDto::getNum));
        Set<Long> ids = numMap.keySet();

        List<ZkItem> skuList = itemClinet.queryItemByIds(new ArrayList<>(ids));
        //计算金额
        // 准备orderDetail集合
        List<OrderDetail> details = new ArrayList<>();
        long totalPay = 0L;
        for (ZkItem zkItem : skuList) {
            totalPay += zkItem.getPrice() * numMap.get(zkItem.getId());

            //封装orderDetail
            OrderDetail detail = new OrderDetail();
            detail.setImage(zkItem.getImage());
            detail.setNum(numMap.get(zkItem.getId()));
            detail.setOrderId(orderId);
            detail.setOwnSpec(zkItem.getSellPoint());
            detail.setPrice(zkItem.getPrice());
            detail.setSkuId(zkItem.getId());
            detail.setTitle(zkItem.getTitle());
            details.add(detail);
        }
        order.setTotalPay(totalPay);
        //实付金额： 总金额 + 邮费 - 优惠金额
        order.setActualPay(totalPay + order.getPostFee() - 0);
        // 1.5 order写入数据库
        int count = orderMapper.insertSelective(order);
        if (count != 1){
            log.error("[创建订单] 创建订单失败，orderId:{}",orderId);
            throw new LyException(ExceptionEnum.CREATE_ORDER_ERROR);
        }
        //2.新增订单详情
        count = detailMapper.insertList(details);
        if (count != details.size()){
            log.error("[创建订单] 创建订单失败，orderId:{}",orderId);
            throw new LyException(ExceptionEnum.CREATE_ORDER_ERROR);
        }
        //3.新增订单状态
        OrderStatus orderStatus = new OrderStatus();
        orderStatus.setCreateTime(order.getCreateTime());
        orderStatus.setOrderId(orderId);
        orderStatus.setStatus(OrderStatusEnum.UN_PAY.value());
        count = statusMapper.insertSelective(orderStatus);
        if (count != 1){
            log.error("[创建订单] 创建订单失败，orderId:{}",orderId);
            throw new LyException(ExceptionEnum.CREATE_ORDER_ERROR);
        }
        //减少库存
        List<CartDto> carts = orderDto.getCarts();
        itemClinet.decreseStock(carts);

        return orderId;
    }

    @Override
    public Order queryOrderById(Long id) {
        Order order = orderMapper.selectByPrimaryKey(id);
        if (order == null){
            //不存在
            throw new LyException(ExceptionEnum.ORDER_NOT_FOUND);
        }
        //查询订单详情
        OrderDetail detail = new OrderDetail();
        detail.setOrderId(id);
        List<OrderDetail> details = detailMapper.select(detail);
        if (CollectionUtils.isEmpty(details)){
            throw new LyException(ExceptionEnum.ORDER_DETAIL_NOT_FOUND);
        }
        order.setOrderDetails(details);
        //查询订单状态
        OrderStatus orderStatus = statusMapper.selectByPrimaryKey(id);
        if (orderStatus == null){
            //不存在
            throw new LyException(ExceptionEnum.ORDER_STATUS_NOT_FOUND);
        }
        order.setOrderStatus(orderStatus);
        return order;
    }

    @Override
    public String createPayUrl(Long orderId) {
        //查询订单
        Order order = queryOrderById(orderId);
        //判断订单状态
        Integer status = order.getOrderStatus().getStatus();
        if (status != OrderStatusEnum.UN_PAY.value()){
            //状态状态异常
            throw new LyException(ExceptionEnum.ORDER_STATUS_ERROR);
        }
        //支付金额  ,修改为1分
        Long totalPay = 1L;     //order.getActualPay();
        //商品描述
        OrderDetail detail = order.getOrderDetails().get(0);
        String desc = detail.getTitle();
        return payHelper.createOrder(orderId,totalPay,desc);
    }

    /**
     * 支付结果通知
     * @param result
     */
    @Override
    public void handleNotify(Map<String, String> result) {
        //1 数据校验
        payHelper.isSuccess(result);

        //2 校验签名
        payHelper.isValidSign(result);

        //3 校验金额
        String totalFeeStr = result.get("total_fee");
        //订单号
        String tradeNo = result.get("out_trade_no");
        if (StringUtils.isBlank(totalFeeStr) || StringUtils.isBlank(tradeNo)){
            throw new LyException(ExceptionEnum.INVALID_ORDER_PARAM);
        }
        //3.1 获取结果中的金额
        long totalFee = Long.valueOf(totalFeeStr);
        //获取订单号
        Long orderId = Long.valueOf(tradeNo);

        //4 查询订单
        Order order = orderMapper.selectByPrimaryKey(orderId);
        if (totalFee != /*order.getActualPay()*/1){
            //金额不符
            throw new LyException(ExceptionEnum.INVALID_ORDER_PARAM);
        }

        //5 修改订单状态
        OrderStatus status = new OrderStatus();
        status.setStatus(OrderStatusEnum.PAYED.value());
        status.setOrderId(orderId);
        status.setPaymentTime(new Date());
        int count =  statusMapper.updateByPrimaryKeySelective(status);
        if (count != 1){
            throw new LyException(ExceptionEnum.UPDATE_ORDERSTATUS_ERROR);
        }

        log.info("[订单回调] 订单支付成功！订单编号:{}",orderId);
    }

    /**
     * 查询订单状态
     * @param orderId
     * @return
     */
    @Override
    public PayState queryOrderStatus(Long orderId) {
        try {
            //查询订单状态
            OrderStatus orderStatus = statusMapper.selectByPrimaryKey(orderId);
            Integer state = orderStatus.getStatus();
            //判断是否支付
            if(state != OrderStatusEnum.UN_PAY.value()){
                //如果已支付，就是真的支付了
                return PayState.SUCCESS;
            }
            Thread.sleep(2000L);
            orderStatus.setPaymentTime(new Date());
            statusMapper.updateByPrimaryKeySelective(orderStatus);
//            return PayState.SUCCESS;
            //如果未支付，需要到微信查询支付状态
            return payHelper.queryPayState(orderId);
        } catch (InterruptedException e) {
            return null;
        }
    }

    @Override
    public PageResult<OrderVo> queryBrandByPage(Integer page, Integer rows, String sortBy, Boolean desc,String status, String key) {
        //分页
        PageHelper.startPage(page, rows);

        //过滤
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNoneBlank(key)) {
            //过滤条件
            criteria.orLike("orderId", "%" + key + "%"/*).orEqualTo("letter", key.toUpperCase()*/);
        }
        //排序
        if (StringUtils.isNoneBlank(sortBy)) {
            String orderByClause = sortBy + (desc ? " DESC" : " ASC");
            example.setOrderByClause(orderByClause);
        }
        //过滤未付款或已付款
        if(StringUtils.isNoneBlank(status)){
            Example example1 = new Example(OrderStatus.class);
            example1.createCriteria().andEqualTo("status",status);
            List<Long> orderIds = statusMapper.selectByExample(example1)
                    .stream().map(OrderStatus::getOrderId).collect(Collectors.toList());
            criteria.andIn("orderId",orderIds);
        }

        //查询
        List<Order> list = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //封装需要显示的数据
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : list) {
            OrderVo oVo = new OrderVo();
            BeanUtils.copyProperties(order,oVo);
//            OrderDetail detail = new OrderDetail();
//            detail.setOrderId(order.getOrderId());
            OrderStatus orderStatus = statusMapper.selectByPrimaryKey(order.getOrderId());
            oVo.setOrderId(orderStatus.getOrderId().toString());
            oVo.setStatus(orderStatus.getStatus());
            orderVos.add(oVo);
        }
        PageInfo<OrderVo> info = new PageInfo<>(orderVos);
        return new PageResult<>(info.getTotal(),orderVos);
    }

    @Override
    public void deleteOrder(String orderId) {
        //同时删除三张表中数据
        if (StringUtils.isNoneBlank(orderId)) {
            orderMapper.deleteByPrimaryKey(orderId);
            OrderDetail detail = new OrderDetail();
            detail.setOrderId(Long.valueOf(orderId));
            detailMapper.delete(detail);
            statusMapper.deleteByPrimaryKey(orderId);
        }
    }

    @Override
    public PageResult<OrderVo> queryOrderByUid(String userId,Integer page) {
        //分页
        PageHelper.startPage(page, 2);

        //过滤
        Example example = new Example(Order.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("userId",userId);
        //查询
        List<Order> list = orderMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)){
            throw new LyException(ExceptionEnum.BRAND_NOT_FOUND);
        }
        //封装需要显示的数据
        List<OrderVo> orderVos = new ArrayList<>();
        for (Order order : list) {
            OrderVo oVo = new OrderVo();
            BeanUtils.copyProperties(order,oVo);
            OrderStatus orderStatus = statusMapper.selectByPrimaryKey(order.getOrderId());
            oVo.setOrderId(order.getOrderId().toString());
            oVo.setStatus(orderStatus.getStatus());
            oVo.setTotalPay(order.getTotalPay());
            orderVos.add(oVo);
        }
        PageInfo<Order> info = new PageInfo<>(list);
        return new PageResult<>(info.getTotal(),(long) info.getPages(),orderVos);
    }
}
