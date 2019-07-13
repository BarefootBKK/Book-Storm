package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/

/**
 * 评论参数类
 */
@Getter
@Setter
public class CommentParam {
    @ApiModelProperty(value = "图书id", required = true)
    private Long bookId;
    @ApiModelProperty(value = "用户id", required = true)
    private Long userId;
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "评论内容", required = true)
    private String content;
}
