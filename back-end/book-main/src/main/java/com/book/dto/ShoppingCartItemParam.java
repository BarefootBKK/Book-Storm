package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 购物车物品参数类
 */
@Getter
@Setter
public class ShoppingCartItemParam {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "图书id", required = true)
    private Long bookId;
    @ApiModelProperty(value = "数量", required = true)
    private Integer count;
}