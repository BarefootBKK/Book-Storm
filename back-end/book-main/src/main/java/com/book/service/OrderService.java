package com.book.service;

import com.book.dto.DeliveryParam;
import com.book.dto.OrderInfoResponse;
import com.book.dto.OrderParam;

import java.util.List;

/**
 * 订单接口
 */
public interface OrderService {
    /**
     * 创建订单
     * @param orderParam 订单参数，参考dto目录：OrderParam
     * @return 订单id
     */
    Long create(OrderParam orderParam);

    /**
     * 支付订单
     * @param orderId 订单id
     * @return 数据库更新的数据数量
     */
    int pay(Long orderId);

    /**
     * 根据用户id订单信息
     * @param username 用户名
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 订单response信息类，参考dto目录：OrderInfoResponse
     */
    List<OrderInfoResponse> listByUsername(String username, Integer pageSize, Integer pageNum);

    /**
     * 根据店铺id获取订单信息
     * @param storeId 店铺id
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 订单response信息类，参考dto目录：OrderInfoResponse
     */
    List<OrderInfoResponse> listByStoreId(Integer storeId, Integer pageSize, Integer pageNum);

    /**
     * 订单发货
     * @param deliveryParam 发货信息，参考dto目录：deliveryParam
     * @return 订单response信息类，参考dto目录：OrderInfoResponse
     */
    List<OrderInfoResponse> delivery(DeliveryParam deliveryParam);
}
