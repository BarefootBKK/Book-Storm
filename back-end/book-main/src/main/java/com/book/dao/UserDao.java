package com.book.dao;

import com.book.dto.UserInfoResponse;
import org.apache.ibatis.annotations.Param;

public interface UserDao {
    /**
     * 获取用户详细信息（username）
     */
    UserInfoResponse getUserDetailInfoByUsername(@Param("username") String username);

    /**
     * 获取用户详细信息（userId）
     */
    UserInfoResponse getUserDetailInfoById(@Param("userId") Long userId);
}
