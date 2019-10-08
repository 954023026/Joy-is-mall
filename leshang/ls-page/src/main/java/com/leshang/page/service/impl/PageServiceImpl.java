package com.leshang.page.service.impl;

import com.leshang.item.pojo.ZkItem;
import com.leshang.page.client.ItemClinet;
import com.leshang.page.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-06 20:10
 */
@Slf4j
@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private TemplateEngine templateEngine;
    @Autowired
    private ItemClinet itemClinet;

    @Override
    public Map<String, Object> loadModel(Long spuId) {
        Map<String, Object> map = new HashMap<>();
        //查询该商品信息
        ZkItem item = itemClinet.queryItemsById(spuId);

        //查询该商品库存

        map.put("item", item);
        return map;
    }

    @Override
    public void deleteHtml(Long spuId) {
        File dest = new File("F:\\IDEA2019\\IDEAFile\\leyou\\upload", spuId + ".html");

        if (dest.exists()){
            dest.delete();
        }
    }

    @Override
    public void createHtml(Long spuId) {
        //上下文
        Context context = new Context();
        context.setVariables(loadModel(spuId));
        //输出流
        File dest = new File("F:\\IDEA2019\\IDEAFile\\leyou\\upload", spuId + ".html");

        if (dest.exists()){
            dest.delete();
        }

        try (PrintWriter writer = new PrintWriter(dest, "UTF-8")) {
            //生成html
            templateEngine.process("item", context, writer);
        } catch (Exception e) {
            log.error("[静态页服务] 生成静态页异常！", e);
        }

    }

}
