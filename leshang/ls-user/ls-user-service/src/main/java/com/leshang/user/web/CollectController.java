package com.leshang.user.web;

import com.leshang.item.pojo.ZkItem;
import com.leshang.user.clinet.ItemClinet;
import com.leshang.user.pojo.ZkAreas;
import com.leshang.user.pojo.ZkCollect;
import com.leshang.user.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 描述:
 * 用户收藏
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-10-24 14:41
 */
@RestController
@RequestMapping("collect")
public class CollectController {

    @Autowired
    private CollectService collectService;

    /**
     * 查询该用户收藏的所有商品
     * @return
     */
    @GetMapping
    public ResponseEntity<List<ZkItem>> queryCollectByUid(Integer uid){
        return  ResponseEntity.ok(collectService.queryCollectByUid(uid));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteCollectByUidAndSpuId(Integer uid,Integer spuId){
        collectService.deleteCollectByUidAndSpuId(uid,spuId);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Void> addCollect(@RequestBody ZkCollect collect){
        collectService.addCollect(collect);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
