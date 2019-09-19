 package com.leshang.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 描述:
 *
 * @author 愿你活的通透拎得清轻重辩得明是非
 * @create 2019-08-23 15:42
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum ExceptionEnum {

    PRICE_CANNOT_NE_NULL(400,"价格不能为空！"),
    ITEM_NOT_FOND(404,"商品没查询到！"),
    UPDATE_BRAND_FAILED(500, "品牌更新失败"),
    SPEC_PARAM_NOT_FOUND(404,"商品规格组没查到"),


    BRAND_NOT_FOUND(404,"品牌不存在！"),
    BRAND_SAVE_ERROR(500,"新增品牌失败！"),
    DELETE_BRAND_EXCEPTION(500, "删除品牌失败"),

    GOODS_NOT_FOND(400,"商品不存在！"),
    GOODS_SAVE_ERROR(500,"新增商品失败"),
    GOODS_DETAIL_NOT_FOND(400,"商品详情不存在！"),
    GOODS_SKU_NOT_FOND(400,"商品SKU不存在！"),
    GOODS_STOCK_NOT_FOND(400,"商品STOCK不存在！"),
    GOODS_UPDATE_ERROR(500,"更新商品失败！"),
    GOODS_ID_CANNOT_BE_NULL(400,"商品id不能为空！"),

    UPLOAD_FILE_ERROR(500,"文件上传失败！"),
    INVALID_FILE_TYPE(400,"无效的文件类型！"),


    INVALID_USER_DATA_TYPE(400,"用户数据类型无效"),
    INVALID_VERIFY_CODE(400,"无效的验证码"),
    INVALID_USERNAME_PASSWORD(400,"用户名或密码错误"),
    UNAUTHORIZED(403,"未授权"),

    CART_NOT_FOUND(404,"购物车为空！"),
    ;

    private int code;
    private String msg;
}
