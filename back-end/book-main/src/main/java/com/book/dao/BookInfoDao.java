package com.book.dao;

import com.book.model.BookInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookInfoDao {
    List<BookInfo> listByCategory(@Param("cateName") String cateName);

    List<BookInfo> queryBookInfoLike(@Param("keyword") String keyword);

    List<BookInfo> listPopularBooks();

    List<BookInfo> listLatestBooks();

    void updateBookLookMount(@Param("bookId") Long bookId);

    void updateBookDealMount(@Param("bookId") Long bookId, @Param("dealMount") Integer dealMount);

    void updateBookStoreMount(@Param("bookId") Long bookId);
}