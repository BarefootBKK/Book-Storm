package com.book.dao;

import com.book.model.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentDao {
    List<Comment> getCommentListByBookId(@Param("bookId") Long bookId);
}
