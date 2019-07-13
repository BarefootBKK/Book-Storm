package com.book.controller;

import com.book.common.api.CommonPage;
import com.book.common.api.CommonResult;
import com.book.config.ScoreConfig;
import com.book.dto.BookWithStoreAndComment;
import com.book.model.BookInfo;
import com.book.service.BookInfoService;
import com.book.service.BookRatingService;
import com.book.service.UserService;
import com.book.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@Api(tags = "BookInfoController", description = "图书管理")
@RequestMapping("/book")
public class BookInfoController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private BookRatingService bookRatingService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserUtil userUtil;

    @ApiOperation("根据id获取图书图书详情")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BookWithStoreAndComment> getBookWithStoreInfo(@RequestParam(value = "id") Long id,
                                                                      HttpServletRequest request) {
        String username = userUtil.getAuthenticatedUsername(request);
        if (username != null) {
            bookRatingService.add(userService.getUserByUsername(username).getId(), id, ScoreConfig.SCORE_VIEW_ONLY);
        }
        return CommonResult.success(bookInfoService.getBookWithStoreAndComment(id));
    }

    @ApiOperation("根据id获取图书图书详情")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<BookInfo> getBook(@PathVariable(value = "id") Long id) {
        return CommonResult.success(bookInfoService.getBookInfoById(id));
    }

    @ApiOperation("根据店铺id获取图书")
    @RequestMapping(value = "/store", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> storeBooks(@RequestParam(value = "storeId") Integer storeId,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BookInfo> list = bookInfoService.listByStoreId(storeId, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("创建图书")
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createBook(@RequestBody BookInfo bookInfo) {
        int count = bookInfoService.createBook(bookInfo);
        if (count > 0) {
            return CommonResult.success(count);
        }
        return null;
    }

    @ApiOperation("更新图书信息")
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<BookInfo> updateBokInfo(@RequestBody BookInfo bookInfo) {
        return CommonResult.success(bookInfoService.updateBookInfo(bookInfo));
    }
}
