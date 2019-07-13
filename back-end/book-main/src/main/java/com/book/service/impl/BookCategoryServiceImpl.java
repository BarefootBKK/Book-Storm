package com.book.service.impl;

import com.book.dao.BookCategoryDao;
import com.book.dto.BookCategoryWithChildrenItem;
import com.book.service.BookCategoryService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCategoryServiceImpl implements BookCategoryService {
    @Autowired
    private BookCategoryDao bookCategoryDao;

    @Override
    public List<BookCategoryWithChildrenItem> listWithChildren(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        return bookCategoryDao.listWithChildren();
    }
}
