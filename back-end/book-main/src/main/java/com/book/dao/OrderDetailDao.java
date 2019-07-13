package com.book.dao;

import com.book.model.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 夏日云泊镇 on 2019/7/8
 **/
public interface OrderDetailDao {
    List<OrderDetail> getOrderDetailByOrderId(@Param(value = "orderId") Long orderId);

    List<OrderDetail> getOrderDetailByStoreId(@Param(value = "storeId") Integer storeId);

    void updateOrderDetail(@Param(value = "orderId") Long orderId,
                           @Param(value = "bookId") Long bookId,
                           @Param(value = "postStatus") Integer postStatus);
}