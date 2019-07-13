package com.book.service;

import com.book.dto.OrderDetailParam;
import com.book.dto.ShoppingCartItemParam;
import com.book.dto.ShoppingCartResponse;
import com.book.model.ShoppingCart;

import java.util.List;

/**
 * 购物车接口
 */
public interface ShoppingCartService {
    /**
     * 根据用户名获取购物车详情
     * @param username 用户名
     * @return 购物车response类，参考dto目录：ShoppingCartResponse
     */
    List<ShoppingCartResponse> listCartItemWithBookInfo(String username);

    /**
     * 插入一条购物车数据
     * @param shoppingCartItemParam 购物车参数类，参考dto目录：shoppingCartItemParam
     * @return 购物车response类，参考dto目录：ShoppingCartResponse
     */
    List<ShoppingCartResponse> insert(ShoppingCartItemParam shoppingCartItemParam);

    /**
     * 根据用户名获取该用户购物车数据
     * @param username 用户名
     * @return 购物车数据
     */
    List<ShoppingCart> list(String username);

    /**
     * 清除购物车（根据OrderDetailParam中的参数来删除）
     * PS：当用户在购物车中去付款后，他/她 购物车中的相应商品应该删除掉
     * @param orderDetailParamList 订单参数类，参考dto目录：根据OrderDetailParam中的参数来删除
     * @return 删除的数据数量
     */
    int deleteByOrderDetail(List<OrderDetailParam> orderDetailParamList);
}
