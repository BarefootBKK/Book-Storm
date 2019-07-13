package com.book.controller;

import com.book.common.api.CommonPage;
import com.book.common.api.CommonResult;
import com.book.dto.BookCategoryWithChildrenItem;
import com.book.dto.HomeBookContent;
import com.book.model.BookInfo;
import com.book.model.Market;
import com.book.service.BookCategoryService;
import com.book.service.BookInfoService;
import com.book.service.MarketService;
import com.book.service.UserService;
import com.book.util.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "IndexController", description = "首页管理")
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private BookInfoService bookInfoService;
    @Autowired
    private MarketService marketService;
    @Autowired
    private BookCategoryService bookCategoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserUtil userUtil;

    @ApiOperation("获取首页书籍")
    @RequestMapping(value = "/contents", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<HomeBookContent>> contents(HttpServletRequest request) {
        return CommonResult.success(bookInfoService.listHome(request));
    }

    @ApiOperation("获取首页轮播模块信息")
    @RequestMapping(value = "/marketing", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Map> marketing() {
        List<Market> marketList = marketService.list(5, 1);
        List<Market> activityList = marketService.list(2, 1);
        Map<String, List<Market>> marketing = new HashMap<>();
        marketing.put("banner", marketList);
        marketing.put("activities", activityList);
        return CommonResult.success(marketing);
    }

    @ApiOperation("根据书名或作者模糊查询书籍")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> search(@RequestParam(value = "query", required = false) String query,
                                                     @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BookInfo> bookInfoList = bookInfoService.listByKeyword(query, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(bookInfoList));
    }

    @ApiOperation(value = "获取用户个性化推荐或热门推荐（带参数 = 个性化；不带参数 = 热门")
    @RequestMapping(value = "/recommend", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> personalizedRecommendation(@RequestParam(value = "username", required = false, defaultValue = "") String username,
                                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, HttpServletRequest request) {
        if (!("".equals(username))) {
            Long userId = userUtil.getAuthenticatedUserId(request);
            if (userId != null) {
                return CommonResult.success(CommonPage.restPage(bookInfoService.listWithPersonalized(userService.getUserByUsername(username).getId(), pageSize, pageNum)));
            }
        }
        return CommonResult.success(CommonPage.restPage(bookInfoService.listWithPopular(pageSize, pageNum + 1)));
    }

    @ApiOperation(value = "获取热门推荐")
    @RequestMapping(value = "/popular", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> popularRecommendation(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(CommonPage.restPage(bookInfoService.listWithPopular(pageSize, pageNum)));
    }

    @ApiOperation("获取最新上架的书")
    @RequestMapping(value = "/latest", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> latest(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BookInfo> bookInfoList = bookInfoService.listWithLatest(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(bookInfoList));
    }

    @ApiOperation("获取所有图书类目")
    @RequestMapping(value = "/category", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookCategoryWithChildrenItem>> category(@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                     @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BookCategoryWithChildrenItem> list = bookCategoryService.listWithChildren(pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("根据类别查找图书")
    @RequestMapping(value = "/items", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<BookInfo>> searchByCategory(@RequestParam(value = "name") String name,
                                                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<BookInfo> bookInfoList = bookInfoService.listByCategory(name, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(bookInfoList));
    }
}
