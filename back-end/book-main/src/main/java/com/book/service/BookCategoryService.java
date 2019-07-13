package com.book.service;

import com.book.dto.BookCategoryWithChildrenItem;

import java.util.List;

/**
 * 图书分类接口
 */
public interface BookCategoryService {
    /**
     * 获取所有的书籍分类
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 图书所有分类，参考dto目录：BookCategoryWithChildrenItem
     */
    List<BookCategoryWithChildrenItem> listWithChildren(Integer pageSize, Integer pageNum);
}
