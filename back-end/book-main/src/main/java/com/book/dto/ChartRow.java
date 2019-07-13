package com.book.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 曲线图“行”
 */
public class ChartRow {
    @ApiModelProperty(value = "x坐标")
    public int x;
    @ApiModelProperty(value = "y坐标")
    public int y;

    /**
     * 构造器
     * @param x x坐标
     * @param y y坐标
     */
    public ChartRow(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
