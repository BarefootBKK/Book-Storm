package com.book.service;

import com.book.model.Store;

/**
 * 店铺接口
 */
public interface StoreService {
    /**
     * 根据店铺id获取店铺信息
     * @param id 店铺id
     * @return 店铺信息
     */
    Store getStoreById(Integer id);

    /**
     * 根据书籍id获取店铺信息
     * @param bookId 书籍id
     * @return 店铺信息
     */
    Store getStoreByBookId(Long bookId);

    /**
     * 获取某个用户的店铺信息（根据用户名获取）
     * @param username 用户名
     * @return 店铺信息
     */
    Store getStoreByUsername(String username);
}