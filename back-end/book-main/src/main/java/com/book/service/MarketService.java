package com.book.service;

import com.book.model.Market;

import java.util.List;

/**
 * market接口
 * 即首页轮播的数据
 * 可以是广告，也可以是活动，或者某本书的推荐
 */
public interface MarketService {
    /**
     * 获取所有数据
     * @return 所有market数据列表
     */
    public List<Market> list();

    /**
     * 分页获取market数据
     * 默认size = 10, num = 1
     * @param pageSize
     * @param pageNum
     * @return market数据列表
     */
    public List<Market> list(Integer pageSize, Integer pageNum);
}
