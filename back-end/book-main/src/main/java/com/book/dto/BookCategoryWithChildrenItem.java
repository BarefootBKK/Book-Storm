package com.book.dto;

import com.book.model.BookCategory;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Created by macro on 2018/5/25.
 */

/**
 * 图书类别
 */
@Getter
@Setter
public class BookCategoryWithChildrenItem extends BookCategory {
    @ApiModelProperty(value = "图书的子分类")
    private List<BookCategory> children;
}
