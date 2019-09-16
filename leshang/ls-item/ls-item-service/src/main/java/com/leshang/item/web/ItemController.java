package com.leshang.item.web;

import com.leshang.item.pojo.ZkItem;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.service.ItemService;
import com.leyou.common.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 *      商品信息
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-23 14:29
 */
@RestController
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    /**
     * 分页查询所有商品，暂时固定分页
     * @param page  当前页
     * @param rows  显示行数
     * @param status    商品状态，默认正常
     * @param key 根据用户输入进行搜索
     * @param cid 商品分类
     * @return  分页信息
     */
    @GetMapping
    public ResponseEntity<PageResult<ZkItem>> queryItemsPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "rows", defaultValue = "14") Integer rows,
            @RequestParam(value = "status",defaultValue = "1") Integer status,
            @RequestParam(value = "key", required = false) String key,
            @RequestParam(value = "cid", required = false) Integer cid
    ) {
        //校验价格
        return ResponseEntity.ok(itemService.queryItemsPage(page,rows,status,key,cid));
    }

    /**
     * 获取商品详情
     * @param id 商品id
     * @return
     */
    @GetMapping("/findItemById")
    public ResponseEntity<ZkItem> queryItemsById(Long id){
        ZkItem item = itemService.finditemById(id);
        return ResponseEntity.ok(item);
    }

    /**
     * 获取商品类别
     * @return
     */
    @GetMapping("/getCats")
    public ResponseEntity<List<ZkItemCat>> queryAllCats(){
        List<ZkItemCat> zkItemCats = itemService.queryAllCat();
        for (ZkItemCat zkItemCat : zkItemCats) {
            zkItemCat.setSortOrder(itemService.queryItemCountByCatId(zkItemCat.getId()));// 获取当前商品类别下的商品数量
        }
        return ResponseEntity.ok(zkItemCats);
    }
    @GetMapping("/getItemsByCid")
    public ResponseEntity<List<ZkItem>> queryItemsByCatId(Long id){
        List<ZkItem> zkItems = itemService.queryItemsByCatId(id);//根据商品类别cid查询当前类别下的所属商品
        return ResponseEntity.ok(zkItems);
    }
    @GetMapping("/queryItemsByPrice")
    public ResponseEntity<List<ZkItem>> queryItemsByPrice(String orderWay){
        List<ZkItem> zkItems=null;
        if(orderWay.equals("ASC")){
            zkItems = itemService.queryItemsByPriceASC();
        }else{
            zkItems = itemService.queryItemsByPriceDESC();
        }
        return ResponseEntity.ok(zkItems);
    }
}
