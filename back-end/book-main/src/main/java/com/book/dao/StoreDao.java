package com.book.dao;

import com.book.model.Store;
import org.apache.ibatis.annotations.Param;

public interface StoreDao {
    Store getStoreByBookId(@Param(value = "bookId") Long bookId);

    Store getStoreByUsername(@Param(value = "username") String username);
}