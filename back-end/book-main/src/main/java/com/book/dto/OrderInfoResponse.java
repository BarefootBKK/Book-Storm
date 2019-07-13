package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息response类
 */
@Getter
@Setter
public class OrderInfoResponse {
    @ApiModelProperty(value = "订单详情id")
    private Long id;
    @ApiModelProperty(value = "书籍id")
    private Long bookId;
    @ApiModelProperty(value = "订单id")
    private Long orderId;
    @ApiModelProperty(value = "邮政编码")
    private String zipCode;
    @ApiModelProperty(value = "店铺id")
    private Integer storeId;
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;
    @ApiModelProperty(value = "订单创建时间")
    private Date createTime;
    @ApiModelProperty(value = "收货人姓名")
    private String receiverName;
    @ApiModelProperty(value = "收货人手机号")
    private String phone;
    @ApiModelProperty(value = "总价")
    private BigDecimal totalPrice;
    @ApiModelProperty(value = "订单状态（未付款/已付款/待发货/已发货/已完成）")
    private Integer status;
    @ApiModelProperty(value = "图书名称")
    private String bookName;
    @ApiModelProperty(value = "收货地址")
    private String address;
    @ApiModelProperty(value = "订单中商品数量")
    private Integer mount;
    @ApiModelProperty(value = "图书图片url")
    private String imageUrl;
}
