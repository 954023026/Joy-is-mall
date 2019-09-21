package com.leshang.search.pojo;

import com.leshang.common.vo.PageResult;
import com.leshang.item.pojo.ZkItemCat;
import com.leshang.item.vo.ZkItemCatVo;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class SearchResult extends PageResult<Items> {


    public SearchResult() {
    }

    public SearchResult(Long total, Long totalPage, List<Items> items) {
        super(total,totalPage,items);
    }
}