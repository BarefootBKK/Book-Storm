package com.book.dao;

import com.book.dto.ShoppingCartResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartDao {
    List<ShoppingCartResponse> listWithBookInfo(@Param("username") String username);
}
