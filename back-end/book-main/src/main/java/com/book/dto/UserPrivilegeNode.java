package com.book.dto;

import com.book.model.Privilege;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 带子权限的用户权限信息类
 */
@Getter
@Setter
public class UserPrivilegeNode extends Privilege {
    @ApiModelProperty(value = "子权限列表")
    private List<UserPrivilegeNode> children;
}
