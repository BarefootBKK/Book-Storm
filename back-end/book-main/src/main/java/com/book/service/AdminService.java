package com.book.service;

import com.book.dto.AdminHomeModules;

import java.util.List;

/**
 * 管理员接口
 */
public interface AdminService {

    /**
     * 获取管理员首页展示“曲线图”数据
     * @return 管理员首页展示模块类，参考dto目录：AdminHomeModules
     */
    List<AdminHomeModules> getHomeModules();

    /**
     * 获取销售额数据
     * @return 管理员首页展示模块类，参考dto目录：AdminHomeModules
     */
    List<AdminHomeModules> getHomeSales();

    /**
     * 获取用户访问量
     * @return 管理员首页展示模块类，参考dto目录：AdminHomeModules
     */
    AdminHomeModules getUserViews();

    double getBookPurchaseRate();
}
