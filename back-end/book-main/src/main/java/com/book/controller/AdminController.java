package com.book.controller;

import com.book.common.api.CommonResult;
import com.book.dto.AdminHomeModules;
import com.book.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Api(tags = "BookCategoryController", description = "图书类别管理")
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @ApiModelProperty("管理员首页折线图显示")
    @RequestMapping(value = "/index/module", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<AdminHomeModules>> modules() {
        return CommonResult.success(adminService.getHomeModules());
    }

    @ApiModelProperty("获取销售额")
    @RequestMapping(value = "/index/sales", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AdminHomeModules> sales() {
        return CommonResult.success(adminService.getHomeSales().get(0));
    }

    @ApiModelProperty("用户访问量")
    @RequestMapping(value = "/index/userViews", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<AdminHomeModules> views() {
        return CommonResult.success(adminService.getUserViews());
    }

    @ApiModelProperty("购书转化率")
    @RequestMapping(value = "/purchaseRate", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult bookPurchaseRate() {
        return CommonResult.success(adminService.getBookPurchaseRate());
    }
}