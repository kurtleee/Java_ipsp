package com.wedu.ipsp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wedu.ipsp.domain.tempData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
// import sun.management.LockInfoCompositeData;

import java.util.List;

@Mapper
@Repository
public interface tempDataMapper extends BaseMapper <tempData> {

    @Select("SELECT * FROM temp_data where source = #{source}")
    List<tempData> selectByFrom(int source);
}
