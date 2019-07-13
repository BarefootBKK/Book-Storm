package com.book.controller;

import com.book.common.api.CommonResult;
import com.book.config.ScoreConfig;
import com.book.dto.*;
import com.book.model.Role;
import com.book.model.ShoppingCart;
import com.book.model.User;
import com.book.service.BookRatingService;
import com.book.service.ShoppingCartService;
import com.book.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Api(tags = "UsersController", description = "用户管理")
@RequestMapping("/user")
public class UsersController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);
    @Autowired
    private UserService userService;
    @Autowired
    private ShoppingCartService shoppingCartService;
    @Autowired
    private BookRatingService bookRatingService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;


/* ========================  登录注册  =============================*/

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<String> register(@RequestBody UserRegisterParam userRegisterParam, BindingResult result) {
        User user = userService.register(userRegisterParam);
        if (user == null) {
            return CommonResult.failed("注册失败");
        }
        return CommonResult.success("注册成功");
    }

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestBody UserLoginParam userLoginParam) {
        String token = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        LOGGER.info("token = " + token);
        return CommonResult.success(tokenMap);
    }

    @ApiOperation(value = "退出登录")
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult logout() {
        return CommonResult.success("您已退出登录");
    }


/* ========================  用户个人信息相关  =============================*/

    @ApiOperation(value = "获取指定用户信息")
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult getUserInfo(@RequestParam(value = "username") String username,
                                    @RequestParam(value = "address", required = false, defaultValue = "1") Integer address) {
        if (address == 1) {
            return CommonResult.success(userService.getUserDetailInfo(username));
        } else {
            return CommonResult.success(userService.getUserByUsername(username));
        }
    }

    @ApiOperation(value = "更新用户信息")
    @RequestMapping(value = "/info/update/{userId}", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<User> updateUserInfo(@RequestBody UserGeneralInfoParam userGeneralInfoParam,
                                       @PathVariable(value = "userId") Long userId) {
        User user = new User();
        if (userGeneralInfoParam != null) {
            user = userService.update(userGeneralInfoParam, userId);
        }
        return CommonResult.success(user);
    }

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/{username}/info", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<User> userInfo(@PathVariable(value = "username") String username) {
        return CommonResult.success(userService.getUserByUsername(username));
    }


/* ========================  用户权限相关  =============================*/

    @ApiOperation("获取指定用户的角色")
    @RequestMapping(value = "/role", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<Role>> getRoleList(@RequestParam(value = "username") String username) {
        List<Role> roleList = userService.getRoleList(username);
        return CommonResult.success(roleList);
    }

    @ApiOperation(value = "更新用户权限信息")
    @RequestMapping(value = "/updatePrivilege", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updatePrivilege(@RequestBody User user) {
        // int result = userService.updatePrivilege(user);
        return CommonResult.success("");
    }


/*=============================  购物车相关 ==================================*/

    @ApiOperation(value = "加入购物车，并返回购物车详情")
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<List<ShoppingCartResponse>> create(
            @RequestBody ShoppingCartItemParam shoppingCartItemParam) {
        bookRatingService.add(userService.getUserByUsername(shoppingCartItemParam.getUsername()).getId(),
                shoppingCartItemParam.getBookId(), ScoreConfig.SCORE_ADD_SHOPPING_CART);
        return CommonResult.success(shoppingCartService.insert(shoppingCartItemParam));
    }

    @ApiOperation(value = "获取购物车详情（返回书籍详情）")
    @RequestMapping(value = "/{username}/shoppingCart", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ShoppingCartResponse>> shoppingCart(@PathVariable(value = "username") String username) {
        return CommonResult.success(shoppingCartService.listCartItemWithBookInfo(username));
    }

    @ApiOperation(value = "获取购物车详情（返回书籍详情）")
    @RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ShoppingCartResponse>> getShoppingCart(@RequestParam(value = "username") String username) {
        return CommonResult.success(shoppingCartService.listCartItemWithBookInfo(username));
    }

    @ApiOperation(value = "获取购物车详情（不返回书籍详情）")
    @RequestMapping(value = "/shoppingCart/{username}", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<ShoppingCart>> getShoppingCartById(@PathVariable(value = "username") String username) {
        return CommonResult.success(shoppingCartService.list(username));
    }


/* ========================  收货地址相关*  =============================*/

    @ApiOperation("添加收货地址")
    @RequestMapping(value = "/address", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<UserInfoResponse> addAddress(@RequestBody AddressParam addressParam) {
        return CommonResult.success(userService.addAddress(addressParam));
    }

    @ApiOperation("删除收货地址")
    @RequestMapping(value = "/address", method = RequestMethod.DELETE)
    @ResponseBody
    public CommonResult<UserInfoResponse> deleteAddress(@RequestParam(value = "userId") Long userId,
                                                        @RequestParam(value = "addressId") Long addressId) {
        return CommonResult.success(userService.deleteAddress(userId, addressId));
    }

    @ApiOperation("修改收货地址")
    @RequestMapping(value = "/address", method = RequestMethod.PUT)
    @ResponseBody
    public CommonResult<UserInfoResponse> updateAddress(@RequestBody AddressParam addressParam) {
        return CommonResult.success(userService.updateAddress(addressParam));
    }
}