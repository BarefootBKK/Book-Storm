package com.book.dao;

import com.book.dto.UserViewsParam;

import java.util.List;

/**
 * Created by 夏日云泊镇 on 2019/7/9
 **/
public interface UserViewDao {
    List<UserViewsParam> listUserViews();
}
