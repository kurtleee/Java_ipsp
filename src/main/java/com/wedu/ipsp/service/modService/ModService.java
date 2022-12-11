package com.wedu.ipsp.service.modService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wedu.ipsp.domain.Mod;
import xin.altitude.cms.common.entity.TreeNode;

import java.util.List;


public interface ModService extends IService<Mod> {

   List<TreeNode<Integer>> FindAllMod();

}
