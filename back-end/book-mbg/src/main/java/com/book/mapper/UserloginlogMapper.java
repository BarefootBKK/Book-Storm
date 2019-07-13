package com.book.mapper;

import com.book.model.Userloginlog;
import com.book.model.UserloginlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserloginlogMapper {
    long countByExample(UserloginlogExample example);

    int deleteByExample(UserloginlogExample example);

    int insert(Userloginlog record);

    int insertSelective(Userloginlog record);

    List<Userloginlog> selectByExample(UserloginlogExample example);

    int updateByExampleSelective(@Param("record") Userloginlog record, @Param("example") UserloginlogExample example);

    int updateByExample(@Param("record") Userloginlog record, @Param("example") UserloginlogExample example);
}