package com.book.controller;

import com.book.common.api.CommonResult;
import com.book.model.Store;
import com.book.service.StoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Api(tags = "StoreController", description = "店铺管理")
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreService storeService;

    @ApiOperation("根据id获取店铺信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Store> store(@RequestParam(value = "id") Integer id) {
        Store store = storeService.getStoreById(id);
        if (store == null) {
            return CommonResult.failed("未找到相关店铺信息");
        }
        return CommonResult.success(store);
    }

    @ApiOperation("根据用户名获取店铺信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Store> userStore(@RequestParam(value = "username") String username) {
        Store store = storeService.getStoreByUsername(username);
        if (store == null) {
            return CommonResult.failed("未找到相关店铺信息");
        }
        return CommonResult.success(store);
    }

    @ApiOperation("创建店铺")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<Store> createStore(@RequestParam(value = "username") String username) {
        Store store = storeService.getStoreByUsername(username);
        if (store == null) {
            return CommonResult.failed("未找到相关店铺信息");
        }
        return CommonResult.success(store);
    }
}
