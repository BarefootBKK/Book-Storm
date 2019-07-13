package com.book.dto;

import com.book.model.BookInfo;
import com.book.model.ShoppingCart;
import lombok.Getter;
import lombok.Setter;

/**
 * 购物车response类（回复用户请求）
 */
public class ShoppingCartResponse extends ShoppingCart {
    @Getter
    @Setter
    private BookInfo bookInfo;
}
