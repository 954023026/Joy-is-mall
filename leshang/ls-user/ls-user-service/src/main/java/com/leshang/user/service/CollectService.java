package com.leshang.user.service;

import com.leshang.item.pojo.ZkItem;
import com.leshang.user.pojo.ZkCollect;

import java.util.List;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-10-24 14:53
 */
public interface CollectService {
    List<ZkItem> queryCollectByUid(Integer uid);

    void deleteCollectByUidAndSpuId(Integer uid, Integer spuId);

    void addCollect(ZkCollect collect);
}
