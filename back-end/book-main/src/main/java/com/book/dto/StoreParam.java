package com.book.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/

/**
 * 店铺参数类
 */
public class StoreParam {
    @ApiModelProperty(value = "用户名", required = true)
    private Long storeManagerId;
    @ApiModelProperty(value = "用户名", required = true)
    private String storePhoneNum;
    @ApiModelProperty(value = "店铺手机号")
    private String storeTelephone;
    @ApiModelProperty(value = "店铺名")
    private String storeName;
    @ApiModelProperty(value = "店铺位置")
    private String StorePosition;
}
