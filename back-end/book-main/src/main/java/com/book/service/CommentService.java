package com.book.service;

import com.book.dto.CommentParam;
import com.book.model.Comment;

import java.util.List;

/**
 * 图书评论接口
 */
public interface CommentService {
    /**
     * 根据书籍id获取评论列表
     * @param book_id 书籍id
     * @return 评论列表
     */
    List<Comment> getCommentListByBookId(Long book_id);

    /**
     * 添加评论
     * @param commentParam 评论参数类，参考dto目录下：CommentParam
     * @return 新的评论列表数据
     */
    List<Comment> addComment(CommentParam commentParam);
}
