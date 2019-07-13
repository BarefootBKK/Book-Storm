package com.book.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

/**
 * 曲线图类
 */
@Setter
@Getter
public class AdminHomeModuleChart {
    @ApiModelProperty(value = "曲线图的列名")
    private String[] columns;
    @ApiModelProperty(value = "曲线图的行")
    private List<Map<String, Integer>> rows;
}
