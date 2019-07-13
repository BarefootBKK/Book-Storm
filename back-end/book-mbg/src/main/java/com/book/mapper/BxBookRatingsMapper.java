package com.book.mapper;

import com.book.model.BxBookRatings;
import com.book.model.BxBookRatingsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BxBookRatingsMapper {
    long countByExample(BxBookRatingsExample example);

    int deleteByExample(BxBookRatingsExample example);

    int insert(BxBookRatings record);

    int insertSelective(BxBookRatings record);

    List<BxBookRatings> selectByExample(BxBookRatingsExample example);

    int updateByExampleSelective(@Param("record") BxBookRatings record, @Param("example") BxBookRatingsExample example);

    int updateByExample(@Param("record") BxBookRatings record, @Param("example") BxBookRatingsExample example);
}