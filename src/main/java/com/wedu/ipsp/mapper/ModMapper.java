package com.wedu.ipsp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wedu.ipsp.domain.Mod;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ModMapper extends BaseMapper<Mod> {
    @Select("SELECT * FROM mod_type")
    List<Mod> selectAllMod();
}
