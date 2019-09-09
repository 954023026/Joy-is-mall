package com.leshang.item.web;

import com.leshang.item.pojo.ZkItem;
import com.leshang.item.service.ItemService;
import com.leyou.common.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

}
