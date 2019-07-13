package com.book.service;

import com.book.dto.AddressParam;
import com.book.dto.UserGeneralInfoParam;
import com.book.dto.UserInfoResponse;
import com.book.dto.UserRegisterParam;
import com.book.model.Privilege;
import com.book.model.Role;
import com.book.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserService {

/*=======================  登录注册相关  ===============================*/

    /**
     * 注册
     * @param userRegisterParam 用户注册必须信息，参考dto目录：userRegisterParam
     * @return 注册完用户信息
     * 失败返回：null
     */
    User register(UserRegisterParam userRegisterParam);

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return token信息
     */
    String login(String username, String password);

    /**
     * 刷新token
     * PS：当一个用户很久不登录，它的浏览器token信息可能已经过期，需要刷新
     * @param oldToken 旧的token
     * @return 新的token
     */
    String refreshToken(String oldToken);


/*=======================  用户信息相关  ===============================*/

    /**
     * 根据用户名获取用户信息
     * @param username 用户名
     * @return 用户信息
     */
    User getUserByUsername(String username);

    /**
     * 根据用户id查询该用户的信息
     * @param id 用户id
     * @return 用户信息
     */
    User getUserById(Long id);

    /**
     * 根据用户名或昵称查询用户信息
     * @param name 用户名或昵称
     * @param pageSize 分页大小
     * @param pageNum 页数
     * @return 所有符合查询条件的用户列表
     */
    List<User> list(String name, Integer pageSize, Integer pageNum);

    /**
     * 更新用户信息
     * @param userGeneralInfoParam 用户更新参数类，参考dto目录：UserGeneralInfoParam
     * @param userId 用户id
     * @return 数据库跟新的数据数量
     */
    User update(UserGeneralInfoParam userGeneralInfoParam, Long userId);

    /**
     * 根据用户id删除
     * @param id 用户id
     * @return 数据库删除的数据数量
     */
    int delete(Long id);

    /**
     * 获取用户信息（带地址和角色信息）
     * @param username 用户名
     * @return 用户信息response信息，参考dto目录：UserInfoResponse
     */
    UserInfoResponse getUserDetailInfo(String username);


/*=======================  用户权限相关  ===============================*/

    /**
     * 更新用户信息
     * @param userId 用户id
     * @param roleIds 角色id
     * @return 数据库更新的数据数量
     */
    @Transactional
    int updateRole(Long userId, List<Long> roleIds);

    /**
     * 获取用户角色列表
     * @param username 用户名
     * @return 角色列表
     */
    List<Role> getRoleList(String username);

    /**
     * 获取用户角色列表
     * @param userId 用户id
     * @return 角色列表
     */
    List<Role> getRoleListByUserId(Long userId);

    /**
     * 更新用户权限（根据角色id）
     * @param roleId 角色id
     * @param privilegeIds 权限列表
     * @return 数据库更新的数据数量
     */
    @Transactional
    int updatePrivilege(Long roleId, List<Long> privilegeIds);

    /**
     * 获取用户权限列表
     * @param userId 用户id
     * @return 权限列表
     */
    List<Privilege> getPrivilegeList(Long userId);


/*=======================  用户地址相关  ===============================*/

    /**
     * 添加地址
     * @param addressParam 地址参数，参考dto目录：AddressParam
     * @return 用户信息，参考参考dto目录：UserInfoResponse
     */
    UserInfoResponse addAddress(AddressParam addressParam);

    /**
     * 删除地址
     * @param userId 用户id
     * @param addressId 地址id
     * @return 用户信息，参考参考dto目录：UserInfoResponse
     */
    UserInfoResponse deleteAddress(Long userId, Long addressId);

    /**
     * 更新地址
     * @param addressParam 地址参数，参考dto目录：AddressParam
     * @return 用户信息，参考参考dto目录：UserInfoResponse
     */
    UserInfoResponse updateAddress(AddressParam addressParam);
}
