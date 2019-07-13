package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 订单参数（用户请求时）
 */
@Getter
@Setter
public class OrderParam {
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;
    @ApiModelProperty(value = "地址id", required = true)
    private Long addressId;
    @ApiModelProperty(value = "备注信息")
    private String message;
    @ApiModelProperty(value = "订单明细", required = true)
    private List<OrderDetailParam> detail;
}
