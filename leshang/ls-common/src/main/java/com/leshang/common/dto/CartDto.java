package com.leshang.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-09-21 11:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;;    //商品skid
    private Integer num;//购买数量
}
