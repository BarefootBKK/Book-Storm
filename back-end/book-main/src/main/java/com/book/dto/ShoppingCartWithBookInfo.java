package com.book.dto;

import com.book.model.BookInfo;
import com.book.model.ShoppingCart;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 带书籍信息的购物车类
 */
@Getter
@Setter
public class ShoppingCartWithBookInfo {
    @ApiModelProperty(value = "书籍信息")
    private BookInfo bookInfo;
    @ApiModelProperty(value = "购物车信息")
    private ShoppingCart shoppingCart;
}
