package com.book.dto;

import com.book.model.Address;
import com.book.model.Role;
import com.book.model.User;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 带收货地址和角色信息的用户类
 */
@Setter
@Getter
public class UserInfoResponse extends User {
    @ApiModelProperty(value = "收货地址列表")
    private List<Address> addressList;
    @ApiModelProperty(value = "角色列表")
    private List<Role> roleList;
}