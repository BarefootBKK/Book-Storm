package com.book.service.impl;

import cn.hutool.core.date.DateTime;
import com.book.dao.UserDao;
import com.book.dao.UserRoleDao;
import com.book.dto.AddressParam;
import com.book.dto.UserGeneralInfoParam;
import com.book.dto.UserInfoResponse;
import com.book.dto.UserRegisterParam;
import com.book.mapper.*;
import com.book.model.*;
import com.book.service.UserService;
import com.book.util.JwtTokenUtil;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String AVATAR = "http://image.baidu.com/search/down?tn=download&word=download&ie=utf8&fr=detail&url=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201510%2F08%2F20151008192345_uPC5U.jpeg&thumburl=http%3A%2F%2Fimg4.imgtn.bdimg.com%2Fit%2Fu%3D3024387196%2C1621670548%26fm%3D26%26gp%3D0.jpg";
    @Autowired
    UserMapper userMapper;
    @Autowired
    PrivilegeMapper privilegeMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    private UserRoleDao userRoleDao;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private UserloginlogMapper userloginlogMapper;
    @Autowired
    private UserDao userDao;
    @Autowired
    private AddressMapper addressMapper;


/*=======================  登录注册  ===============================*/

    @Override
    public User register(UserRegisterParam userRegisterParam) {
        User user = new User();
        BeanUtils.copyProperties(userRegisterParam, user);
        user.setCreated(new Date());
        user.setActive(true);
        user.setAvatar(AVATAR);
        user.setNickname(userRegisterParam.getUsername());
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(user.getUsername());
        List<User> userList = userMapper.selectByExample(example);
        if (userList.size() > 0) {
            return null;
        }
        //  将密码加密
        // String encodePassword = passwordEncoder.encode(user.getPassword());
        // user.setPassword(encodePassword);
        userMapper.insert(user);
        return user;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        // 密码需要客户端加密后传输
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            // 解密匹配账号和密码
            // if (!passwordEncoder.matches(password, userDetails.getPassword())) {
            //     throw new BadCredentialsException("密码不正确");
            // }
            if (!matches(username, password)) {
                throw new BadCredentialsException("账号或密码不正确");
            }
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            token= jwtTokenUtil.generateToken(userDetails);
            insertLoginLog(username);
        } catch (AuthenticationException e) {
            LOGGER.warn("登录异常:{}", e.getMessage());
        }
        return token;
    }

    @Override
    public String refreshToken(String oldToken) {
        String token = oldToken.substring(tokenHead.length());
        if (jwtTokenUtil.canRefresh(token)) {
            return jwtTokenUtil.refreshToken(token);
        }
        return null;
    }

    /**
     * 插入用户登录信息
     */
    private void insertLoginLog(String username) {
        User user = getUserByUsername(username);
        Userloginlog userloginlog = new Userloginlog();
        userloginlog.setUserId(user.getId());
        userloginlog.setUsername(username);
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        userloginlog.setIp(request.getRemoteAddr());
        userloginlogMapper.insert(userloginlog);
    }

    /**
     * 验证用户登录的账号密码是否正确
     */
    private boolean matches(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null && userList.size() > 0) {
            return true;
        }
        return false;
    }


/*=======================  用户信息相关  ===============================*/

    /**
     * 通过用户名获取用户
     */
    @Override
    public User getUserByUsername(String username) {
        if (username != null) {
            UserExample example = new UserExample();
            UserExample.Criteria criteria = example.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<User> userList = userMapper.selectByExample(example);
            if (userList != null && userList.size() > 0) {
                return userList.get(0);
            }
        }
        return null;
    }

    /**
     * 通过id获取用户
     */
    @Override
    public User getUserById(Long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    /**
     * 根据用户名查找用户
     */
    @Override
    public List<User> list(String name, Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty(name)) {
            criteria.andUsernameLike("%" + name + "%");
            example.or(example.createCriteria().andNicknameLike("%" + name + "%"));
        }
        return userMapper.selectByExample(example);
    }

    /**
     * 更新用户信息
     */
    @Override
    public User update(UserGeneralInfoParam userGeneralInfoParam, Long userId) {
        User user = getUserById(userId);
        if (user != null) {
            BeanUtils.copyProperties(userGeneralInfoParam, user);
            user.setNickname(userGeneralInfoParam.getNickName());
            userMapper.updateByPrimaryKey(user);
        }
        return user;
    }

    /**
     * 删除用户
     */
    @Override
    public int delete(Long id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * 获取用户详细信息
     * 带：收货地址和用户角色列表信息
     */
    @Override
    public UserInfoResponse getUserDetailInfo(String username) {
        UserInfoResponse infoResponse = userDao.getUserDetailInfoByUsername(username);
        infoResponse.setRoleList(getRoleList(username));
        return infoResponse;
    }


/*=======================  用户信息相关  ===============================*/

    /**
     * 更新用户角色
     */
    @Override
    public int updateRole(Long userId, List<Long> roleIds) {
        int count = roleIds == null ? 0 : roleIds.size();
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria().andUserIdEqualTo(userId);
        userRoleMapper.deleteByExample(userRoleExample);
        if (!CollectionUtils.isEmpty(roleIds)) {
            List<UserRole> userRoleList = new ArrayList<>();
            for (Long roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                userRoleList.add(userRole);
            }
            // insert操作
            userRoleDao.insertList(userRoleList);
        }
        return count;
    }

    /**
     * 获取角色列表（通过用户id）
     */
    @Override
    public List<Role> getRoleListByUserId(Long userId) {
        return userRoleDao.getRoleListByUserId(userId);
    }

    /**
     * 获取用户角色列表（通过用户名）
     * @param username
     * @return
     */
    @Override
    public List<Role> getRoleList(String username) {
        User user = getUserByUsername(username);
        if (user == null) {
            return null;
        }
        return userRoleDao.getRoleList(username);
    }

    /**
     * 更新用户权限列表
     */
    @Override
    public int updatePrivilege(Long userId, List<Long> privilegeIds) {
        return 0;
    }

    /**
     * 获取用户权限列表
     */
    @Override
    public List<Privilege> getPrivilegeList(Long userId) {
        return userRoleDao.getPrivilegeList(userId);
    }


/*=======================  用户地址相关  ===============================*/

    /**
     * 添加地址
     */
    @Override
    public UserInfoResponse addAddress(AddressParam addressParam) {
        Address address = new Address();
        BeanUtils.copyProperties(addressParam, address);
        address.setCreated(new DateTime());
        addressMapper.insert(address);
        UserInfoResponse userInfoResponse = userDao.getUserDetailInfoByUsername(addressParam.getUsername());
        userInfoResponse.setRoleList(getRoleList(addressParam.getUsername()));
        return userInfoResponse;
    }

    /**
     * 删除地址
     */
    @Override
    public UserInfoResponse deleteAddress(Long userId, Long addressId) {
        addressMapper.deleteByPrimaryKey(addressId);
        UserInfoResponse infoResponse = userDao.getUserDetailInfoById(userId);
        infoResponse.setRoleList(getRoleListByUserId(userId));
        return infoResponse;
    }

    /**
     * 更新地址信息
     */
    @Override
    public UserInfoResponse updateAddress(AddressParam addressParam) {
        Address address = new Address();
        BeanUtils.copyProperties(addressParam, address);
        address.setId(addressParam.getId());
        address.setUpdated(new DateTime());
        addressMapper.updateByPrimaryKeySelective(address);
        UserInfoResponse infoResponse = userDao.getUserDetailInfoById(address.getUserId());
        infoResponse.setRoleList(getRoleList(addressParam.getUsername()));
        return infoResponse;
    }
}
