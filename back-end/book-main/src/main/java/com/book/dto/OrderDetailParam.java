package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 订单详情参数类
 */
@Getter
@Setter
public class OrderDetailParam {
    @ApiModelProperty(value = "图书id", required = true)
    private Long bookId;
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;
    @ApiModelProperty(value = "购物车id", required = true)
    private Long shoppingCartId;
    @ApiModelProperty(value = "商品数量", required = true)
    private Integer mount;
    @ApiModelProperty(value = "单价", required = true)
    private String price;
    @ApiModelProperty(value = "总价", required = true)
    private String totalPrice;
    @ApiModelProperty(value = "图书名称", required = true)
    private String bookName;
    @ApiModelProperty(value = "图书图片url", required = true)
    private String imgUrl;
    @ApiModelProperty(value = "其它信息", required = true)
    private String info;
}
