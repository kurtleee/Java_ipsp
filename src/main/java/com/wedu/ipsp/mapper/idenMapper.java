package com.wedu.ipsp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.domain.iden;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface idenMapper extends BaseMapper<iden> {
    @Select("select * from t_iden")
    List<iden> findAllUser();
}
