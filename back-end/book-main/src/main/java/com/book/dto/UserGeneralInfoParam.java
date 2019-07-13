package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Email;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/

/**
 * 用户更新
 */
@Getter
@Setter
public class UserGeneralInfoParam {
    @ApiModelProperty(value = "昵称")
    private String nickName;
    @ApiModelProperty(value = "用户手机")
    private String phone;
    @ApiModelProperty(value = "用户性别")
    private String gender;
    @ApiModelProperty(value = "邮箱")
    @Email(message = "邮箱格式不合法")
    private String email;
    @ApiModelProperty(value = "真实姓名")
    private String realName;
}
