package com.leshang.item.web;

import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.service.ItemCatService;
import com.leshang.item.vo.ZkItemCatVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-20 10:43
 */
@RestController
@RequestMapping("/itemCat")
public class ItemCatController {

    @Autowired
    private ItemCatService itemCatService;

    /**
     * 根据分类id查询该id下所有分类
     *
     * @return
     */
    @GetMapping("/cid")
    public ResponseEntity<ZkItemCat> queryCatById(@RequestParam("id") Long id) {
        return ResponseEntity.ok(itemCatService.queryCatById(id));
    }

    /**
     * 根据分类id集合查询分类
     *
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<List<ZkItemCatVo>> queryItemCatByIds(@RequestParam("ids") List<Long> ids) {
        return ResponseEntity.ok(itemCatService.queryItemCatByIds(ids));
    }

    /**
     * 获取商品类别
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ZkItemCatVo>> queryAllCats() {
        return ResponseEntity.ok(itemCatService.queryAllCat());
    }

}
