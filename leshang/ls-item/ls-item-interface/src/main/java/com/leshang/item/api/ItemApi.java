package com.leshang.item.api;

import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Author: Adorez
 * @Date: 2019/9/18 9:14
 * @Description:
 */
@RequestMapping("item")
public interface ItemApi {
    /**
     * 获取商品详情
     * @param id 商品id
     * @return
     */
    @GetMapping("findItemById/{id}")
    public ZkItem queryItemsById(@PathVariable("id") Long id);

    /**
     * 分页查询所有商品，暂时固定分页
     *
     * @param page   当前页
     * @param rows   显示行数
     * @param status 商品状态，默认正常
     * @param key    根据用户输入进行搜索
     * @param cid    商品分类
     * @return 分页信息
     */
    @GetMapping
    public PageResult<ZkItem> queryItemsPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "14") Integer rows,
            @RequestParam(value = "status", defaultValue = "1") Integer status,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "cid", required = false) Integer cid
    );


    /**
     * 获取商品类别
     * @return
     */
    @GetMapping("/getCats")
    public List<ZkItemCat> queryAllCats();

    /**
     * 根据商品分类id，查询商品
     * @param id
     * @return
     */
    @GetMapping("/getItemsByCid")
    public List<ZkItem> queryItemsByCatId(Long id);


}
