package com.leshang.page.service;

import java.util.Map;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-06 20:08
 */
public interface PageService {

    Map<String, Object> loadModel(Long spuId);

    void createHtml(Long spuId);

    void deleteHtml(Long spuId);
}
