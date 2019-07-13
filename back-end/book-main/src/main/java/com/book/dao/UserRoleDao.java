package com.book.dao;

import com.book.model.Privilege;
import com.book.model.Role;
import com.book.model.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserRoleDao {
    /**
     * 批量插入角色
     */
    int insertList(@Param("list")List<UserRole> userRoleList);

    /**
     * 获取角色列表
     */
    List<Role> getRoleList(@Param("username") String username);

    /**
     * 获取角色列表（通过用户id）
     */
    List<Role> getRoleListByUserId(@Param("userId") Long userId);

    List<Privilege> getRolePrivilegeList(@Param("roleId") Long roleId);

    List<Privilege> getPrivilegeList(@Param("userId") Long userId);

    List<Privilege> getPrivilegeListByUsername(@Param("username") Long userId);
}
