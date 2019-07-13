package com.book.dao;

import com.book.model.OrderInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 夏日云泊镇 on 2019/7/8
 **/
public interface OrderInfoDao {
    List<OrderInfo> getOrderInfoListByUsername(@Param(value = "username") String username);
}