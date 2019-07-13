package com.book.dao;

import com.book.model.OrderShipping;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 夏日云泊镇 on 2019/7/8
 **/
public interface OrderShippingDao {
    OrderShipping getOrderShipping(@Param(value = "orderId") Long orderId);
}
