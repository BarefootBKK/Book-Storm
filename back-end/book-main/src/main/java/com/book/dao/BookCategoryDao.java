package com.book.dao;

import com.book.dto.BookCategoryWithChildrenItem;

import java.util.List;

public interface BookCategoryDao {
    List<BookCategoryWithChildrenItem> listWithChildren();
}
