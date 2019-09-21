package com.leshang.item.api;

import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.vo.ZkItemCatVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequestMapping("itemCat")
public interface ItemCatApi {
    /**
     *    查询分类
     * @return
     */
    @GetMapping("cid")
    public ZkItemCat queryCatById(@RequestParam("id") Long id);

    /**
     *  根据分类id集合查询分类
     * @return
     */
    @GetMapping("/list")
    public List<ZkItemCatVo> queryItemCatByIds(@RequestParam("ids") List<Long> ids);
}
