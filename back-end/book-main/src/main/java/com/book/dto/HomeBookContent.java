package com.book.dto;

import com.book.model.BookInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 首页书籍类
 */
@Getter
@Setter
public class HomeBookContent {
    @ApiModelProperty(value = "模块标题，如：个性化推荐，热门推荐")
    private String title;
    @ApiModelProperty(value = "书籍信息列表")
    private List<BookInfo> bookInfoList;

    public HomeBookContent(String title, List<BookInfo> bookInfoList) {
        this.title = title;
        this.bookInfoList = bookInfoList;
    }
}
