package com.book.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Api(tags = "RoleController", description = "角色管理")
@RequestMapping("/role")
public class RoleController {
    // 暂时无数据
}
