package com.book.mapper;

import com.book.model.BookDesc;
import com.book.model.BookDescExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BookDescMapper {
    long countByExample(BookDescExample example);

    int deleteByExample(BookDescExample example);

    int insert(BookDesc record);

    int insertSelective(BookDesc record);

    List<BookDesc> selectByExample(BookDescExample example);

    int updateByExampleSelective(@Param("record") BookDesc record, @Param("example") BookDescExample example);

    int updateByExample(@Param("record") BookDesc record, @Param("example") BookDescExample example);
}