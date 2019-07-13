package com.book.controller;

import com.book.common.api.CommonResult;
import com.book.dto.CommentParam;
import com.book.model.Comment;
import com.book.service.CommentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@Api(tags = "CommentController", description = "评论管理")
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @ApiOperation("根据书籍id获取评论列表")
    @RequestMapping(value = "/book", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Comment>> commentList(@RequestParam(value = "id") Long id) {
        List<Comment> commentList = commentService.getCommentListByBookId(id);
        return CommonResult.success(commentList);
    }

    @ApiOperation("添加评论")
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<List<Comment>> addComment(@RequestBody CommentParam commentParam) {
        List<Comment> commentList = commentService.addComment(commentParam);
        return CommonResult.success(commentList);
    }
}
