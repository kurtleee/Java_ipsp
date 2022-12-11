package com.wedu.ipsp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wedu.ipsp.domain.tableData;
import com.wedu.ipsp.domain.tempData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface tableDataMapper extends BaseMapper<tableData> {
    @Select("SELECT * FROM table_data ;")
    List<tableData> selectall();
}
