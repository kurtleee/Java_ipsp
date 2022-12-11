package com.wedu.ipsp.service.modService.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wedu.ipsp.domain.Mod;
import com.wedu.ipsp.mapper.ModMapper;
import com.wedu.ipsp.service.modService.ModService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xin.altitude.cms.common.entity.TreeNode;
import xin.altitude.cms.common.util.TreeUtils;

import java.util.List;

@Service
public class ModServiceImpl extends ServiceImpl<ModMapper,Mod> implements ModService {
    @Autowired
    private ModMapper modMapper;


    @Override
    public List<TreeNode<Integer>> FindAllMod() {
        List<Mod> mods = modMapper.selectAllMod();
        List<TreeNode<Integer>> treeNodes = TreeUtils.createNode(mods, 0);
        return treeNodes;


//        List<Mod> modList=new ArrayList<>();
//        for (Mod mod : mods) {
//            if(mod.getTypeParentId().equals("0")){
//                modList.add(mod);
//            }
//        }
//        System.out.println(modList);
//        System.out.println(mods);
//******************************************************************************************
//        for (int i = 0; i < modList.size(); i++) {
//            List<Mod> modc = new ArrayList<>();
//            for (Mod mod : mods) {
//                if(mod.getTypeParentId().equals(modList.get(i))){
//                    modc.add(mod);
//                }
////                System.out.println(modc);
//            }
//
//              modList.get(i).setModTrees(modc);
//            modc.clear();
//        }
//       // System.out.println(modList.get(0).getModTrees().get(0));
//        return modList;
    }
}
