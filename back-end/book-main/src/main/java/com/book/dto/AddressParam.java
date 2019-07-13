package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 地址参数类
 */
@Getter
@Setter
public class AddressParam {
    @ApiModelProperty(value = "地址id")
    private Long id;
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "省份", required = true)
    private String province;
    @ApiModelProperty(value = "城市", required = true)
    private String city;
    @ApiModelProperty(value = "地区", required = true)
    private String district;
    @ApiModelProperty(value = "详细地址", required = true)
    private String address;
    @ApiModelProperty(value = "邮编")
    private String zipCode;
    @ApiModelProperty(value = "收货人姓名", required = true)
    private String name;
    @ApiModelProperty(value = "手机号", required = true)
    private String phone;
}