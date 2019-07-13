package com.book.service;

import com.book.model.Role;

/**
 * 用户角色接口
 */
public interface UserRoleService {
    /**
     * 根据用户名获取角色信息
     * @param username 用户名
     * @return 角色信息
     */
    public Role getRoleByUsername(String username);
}
