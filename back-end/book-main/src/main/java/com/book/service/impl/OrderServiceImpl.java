package com.book.service.impl;

import cn.hutool.core.date.DateTime;
import com.book.dao.BookInfoDao;
import com.book.dao.OrderInfoDao;
import com.book.dao.OrderDetailDao;
import com.book.dao.OrderShippingDao;
import com.book.dto.DeliveryParam;
import com.book.dto.OrderDetailParam;
import com.book.dto.OrderParam;
import com.book.dto.OrderInfoResponse;
import com.book.mapper.*;
import com.book.model.*;
import com.book.service.OrderService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private OrderShippingMapper orderShippingMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private OrderShippingDao orderShippingDao;
    @Autowired
    private OrderInfoDao orderInfoDao;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private BookInfoDao bookInfoDao;

    @Override
    public Long create(OrderParam orderParam) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setUserId(orderParam.getUserId());
        orderInfo.setPayment(getPayment(orderParam.getDetail()));
        orderInfo.setPostFee("0.00");
        orderInfo.setBuyerMessage(orderParam.getMessage());
        orderInfo.setCreateTime(new DateTime());
        orderInfo.setUpdateTime(new DateTime());
        orderInfo.setOrderMount(orderParam.getDetail().size());
        orderInfo.setShippingName("顺丰");
        orderInfo.setStatus(1);
        orderInfoMapper.insert(orderInfo);
        createOrderDetail(orderInfo.getId(), orderParam.getDetail());
        createShipping(orderInfo.getId(), orderParam.getAddressId());
        for (OrderDetailParam orderDetailParam : orderParam.getDetail()) {
            bookInfoDao.updateBookDealMount(orderDetailParam.getBookId(), orderDetailParam.getMount());
            bookInfoDao.updateBookStoreMount(orderDetailParam.getBookId());
        }
        return orderInfo.getId();
    }

    @Override
    public int pay(Long orderId) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(orderId);
        orderInfo.setStatus(2);
        orderInfo.setPaymentTime(new DateTime());
        return orderInfoMapper.updateByPrimaryKey(orderInfo);
    }

    @Override
    public List<OrderInfoResponse> listByUsername(String username, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderInfo> orderInfoList = orderInfoDao.getOrderInfoListByUsername(username);
        if (orderInfoList != null) {
            List<OrderInfoResponse> orderInfoResponseList = new ArrayList<>();
            for (OrderInfo orderInfo : orderInfoList) {
                OrderShipping orderShipping = orderShippingDao.getOrderShipping(orderInfo.getId());
                List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailByOrderId(orderInfo.getId());
                for (OrderDetail orderDetail : orderDetails) {
                    OrderInfoResponse orderInfoResponse = new OrderInfoResponse();
                    BeanUtils.copyProperties(orderDetail, orderInfoResponse);
                    orderInfoResponse.setOrderId(orderInfo.getId());
                    orderInfoResponse.setBookId(orderDetail.getBookId());
                    orderInfoResponse.setStatus(orderInfo.getStatus());
                    orderInfoResponse.setAddress(getFullAddress(orderShipping));
                    orderInfoResponse.setReceiverName(orderShipping.getReceiverName());
                    orderInfoResponse.setPhone(orderShipping.getReceiverPhone());
                    orderInfoResponse.setCreateTime(orderInfo.getCreateTime());
                    orderInfoResponseList.add(orderInfoResponse);
                }
            }
            return orderInfoResponseList;
        }
        return null;
    }

    @Override
    public List<OrderInfoResponse> listByStoreId(Integer storeId, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        List<OrderDetail> orderDetails = orderDetailDao.getOrderDetailByStoreId(storeId);
        if (orderDetails.size() > 0) {
            List<OrderInfoResponse> orderInfoResponseList = new ArrayList<>();
            Long orderId = orderDetails.get(0).getOrderId();
            OrderInfo orderInfo = orderInfoMapper.selectByPrimaryKey(orderId);
            OrderShipping orderShipping = orderShippingDao.getOrderShipping(orderId);
            for (OrderDetail orderDetail : orderDetails) {
                OrderInfoResponse orderInfoResponse = new OrderInfoResponse();
                BeanUtils.copyProperties(orderDetail, orderInfoResponse);
                orderInfoResponse.setOrderId(orderInfo.getId());
                orderInfoResponse.setBookId(orderDetail.getBookId());
                orderInfoResponse.setStatus(orderDetail.getPostStatus());
                orderInfoResponse.setZipCode(orderShipping.getReceiverZip());
                orderInfoResponse.setAddress(getFullAddress(orderShipping));
                orderInfoResponse.setReceiverName(orderShipping.getReceiverName());
                orderInfoResponse.setPhone(orderShipping.getReceiverPhone());
                orderInfoResponse.setCreateTime(orderInfo.getCreateTime());
                orderInfoResponseList.add(orderInfoResponse);
            }
            return orderInfoResponseList;
        }
        return null;
    }

    /**
     * 获取支付金额
     * @param orderDetailParamList
     * @return
     */
    private String getPayment(List<OrderDetailParam> orderDetailParamList) {
        BigDecimal totalPrice = new BigDecimal(new Double(0));
        for (OrderDetailParam orderDetailParam : orderDetailParamList) {
            totalPrice = totalPrice.add(new BigDecimal(orderDetailParam.getTotalPrice()));
        }
        return totalPrice.toString();
    }

    /**
     * 创建订单明细
     */
    private void createOrderDetail(Long orderId, List<OrderDetailParam> orderDetailParamList) {
        for (OrderDetailParam orderDetailParam : orderDetailParamList) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setBookId(orderDetailParam.getBookId());
            orderDetail.setStoreId(orderDetailParam.getStoreId());
            orderDetail.setPostStatus(1);
            orderDetail.setMount(orderDetailParam.getMount());
            orderDetail.setUnitPrice(new BigDecimal(orderDetailParam.getPrice()));
            orderDetail.setTotalPrice(new BigDecimal(orderDetailParam.getTotalPrice()));
            orderDetail.setBookName(orderDetailParam.getBookName());
            orderDetail.setImageUrl(orderDetailParam.getImgUrl());
            orderDetail.setOrderNumber(Long.toString(System.currentTimeMillis()));
            orderDetailMapper.insert(orderDetail);
        }
    }

    /**
     * 创建运输信息
     */
    private void createShipping(Long orderId, Long addressId) {
        Address address =  addressMapper.selectByPrimaryKey(addressId);
        OrderShipping orderShipping = new OrderShipping();
        orderShipping.setOrderId(orderId);
        orderShipping.setReceiverName(address.getName());
        orderShipping.setReceiverPhone(address.getPhone());
        orderShipping.setReceiverProvince(address.getProvince());
        orderShipping.setReceiverCity(address.getCity());
        orderShipping.setReceiverDistrict(address.getDistrict());
        orderShipping.setReceiverAddress(address.getAddress());
        orderShipping.setReceiverZip(address.getZipCode());
        orderShipping.setCreated(new DateTime());
        orderShippingMapper.insert(orderShipping);
    }

    private String getFullAddress(OrderShipping orderShipping) {
        String address = orderShipping.getReceiverProvince() +
                orderShipping.getReceiverCity() +
                orderShipping.getReceiverDistrict() +
                orderShipping.getReceiverAddress();
        return address;
    }

    @Override
    public List<OrderInfoResponse> delivery(DeliveryParam deliveryParam) {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setId(deliveryParam.getOrderId());
        orderInfo.setShippingName(deliveryParam.getShippingName());
        orderInfo.setShippingCode(deliveryParam.getShippingCode());
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(deliveryParam.getId());
        orderDetail.setPostStatus(2);
        orderDetailMapper.updateByPrimaryKey(orderDetail);
        // orderDetailDao.updateOrderDetail(deliveryParam.getOrderId(), deliveryParam.getBookId(), 2);
        return listByStoreId(deliveryParam.getStoreId(), 10, 1);
    }
}
