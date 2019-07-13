package com.book.dto;

import com.book.model.BookInfo;
import com.book.model.Comment;
import com.book.model.Store;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 图书信息类（含店铺信息和评论信息）
 */
@Getter
@Setter
public class BookWithStoreAndComment {
    @ApiModelProperty(value = "店铺类")
    private Store store;
    @ApiModelProperty(value = "图书信息类")
    private BookInfo bookInfo;
    @ApiModelProperty(value = "评论列表")
    private List<Comment> commentList;
}
