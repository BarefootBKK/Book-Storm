package com.book.mapper;

import com.book.model.BxClickstreamLog;
import com.book.model.BxClickstreamLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BxClickstreamLogMapper {
    long countByExample(BxClickstreamLogExample example);

    int deleteByExample(BxClickstreamLogExample example);

    int insert(BxClickstreamLog record);

    int insertSelective(BxClickstreamLog record);

    List<BxClickstreamLog> selectByExample(BxClickstreamLogExample example);

    int updateByExampleSelective(@Param("record") BxClickstreamLog record, @Param("example") BxClickstreamLogExample example);

    int updateByExample(@Param("record") BxClickstreamLog record, @Param("example") BxClickstreamLogExample example);
}