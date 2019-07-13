package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 曲线图模块类
 */
@Getter
@Setter
public class AdminHomeModules {
    @ApiModelProperty(value = "曲线图的标题")
    private String title;
    @ApiModelProperty(value = "曲线图参数类")
    private AdminHomeModuleChart chartData;
}
