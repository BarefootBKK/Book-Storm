package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/

/**
 * 发货类
 */
@Setter
@Getter
public class DeliveryParam {
    @ApiModelProperty(value = "订单详情id", required = true)
    private Long id;
    @ApiModelProperty(value = "店铺id", required = true)
    private Integer storeId;
    @ApiModelProperty(value = "图书id", required = true)
    private Long bookId;
    @ApiModelProperty(value = "订单id", required = true)
    private Long orderId;
    @ApiModelProperty(value = "物流公司", required = true)
    private String shippingName;
    @ApiModelProperty(value = "物流单号", required = true)
    private String shippingCode;
}
