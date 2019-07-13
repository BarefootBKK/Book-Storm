package com.book.controller;

import com.book.common.api.CommonPage;
import com.book.common.api.CommonResult;
import com.book.config.ScoreConfig;
import com.book.dto.DeliveryParam;
import com.book.dto.OrderDetailParam;
import com.book.dto.OrderInfoResponse;
import com.book.dto.OrderParam;
import com.book.service.BookRatingService;
import com.book.service.OrderService;
import com.book.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "OrderController", description = "订单管理")
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BookRatingService bookRatingService;
    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation("创建订单")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Map> create(@RequestBody OrderParam orderParam) {
        Map<String, Long> map = new HashMap<>();
        map.put("orderId", orderService.create(orderParam));
        // 清除购物车里的相关商品
        shoppingCartService.deleteByOrderDetail(orderParam.getDetail());
        // 添加评分
        for (OrderDetailParam orderDetailParam : orderParam.getDetail()) {
            bookRatingService.add(orderParam.getUserId(), orderDetailParam.getBookId(), ScoreConfig.SCORE_PAY);
        }
        return CommonResult.success(map);
    }

    @ApiOperation("支付订单")
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult pay(@RequestParam(value = "orderId") Long orderId) {
        return CommonResult.success(orderService.pay(orderId));
    }

    @ApiOperation("用户订单列表")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OrderInfoResponse>> listOrder(@RequestParam(value = "username") String username,
                                                         @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                         @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<OrderInfoResponse> orderInfoList = orderService.listByUsername(username, pageSize, pageNum);
        return CommonResult.success(CommonPage.restPage(orderInfoList));
    }

    @ApiOperation("根据店铺id获取订单")
    @RequestMapping(value = "/store", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<OrderInfoResponse>> getOrdersByStoreId(@RequestParam(value = "storeId") Integer storeId,
                                                                          @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize,
                                                                          @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return CommonResult.success(CommonPage.restPage(orderService.listByStoreId(storeId, pageSize, pageNum)));
    }

    @ApiOperation("订单发货")
    @RequestMapping(value = "/delivery", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<CommonPage<OrderInfoResponse>> delivery(@RequestBody DeliveryParam deliveryParam) {
        return CommonResult.success(CommonPage.restPage(orderService.delivery(deliveryParam)));
    }
}