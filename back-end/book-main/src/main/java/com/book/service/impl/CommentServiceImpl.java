package com.book.service.impl;

import cn.hutool.core.date.DateTime;
import com.book.dao.CommentDao;
import com.book.dto.CommentParam;
import com.book.mapper.CommentMapper;
import com.book.model.Comment;
import com.book.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentListByBookId(Long book_id) {
        return commentDao.getCommentListByBookId(book_id);
    }

    @Override
    public List<Comment> addComment(CommentParam commentParam) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentParam, comment);
        comment.setDate(new DateTime());
        commentMapper.insert(comment);
        return commentDao.getCommentListByBookId(commentParam.getBookId());
    }
}
