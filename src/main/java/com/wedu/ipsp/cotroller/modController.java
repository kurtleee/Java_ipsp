package com.wedu.ipsp.cotroller;

import com.wedu.ipsp.domain.Mod;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.service.modService.ModService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xin.altitude.cms.common.entity.TreeNode;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/mod/")
public class modController {
    @Autowired
    private ModService modService;

    @PostMapping("addMod")
    public ResultInfo addMod(@RequestBody  Mod mod){
        boolean save = modService.save(mod);
        return new ResultInfo(save);
    }
    @DeleteMapping("deleteMod")
    public ResultInfo deleteMod(@RequestBody Mod mod){
        boolean remove = modService.removeById(mod);
        return new ResultInfo(remove);
    }
    @PutMapping("updateMod")
    public ResultInfo updateMod(@RequestBody Mod mod){
        boolean update = modService.updateById(mod);
        return new ResultInfo(update);
    }

    @GetMapping("findAllMod")
    public ResultInfo getAllMod(){
        ResultInfo R=new ResultInfo();
        try {
            List<TreeNode<Integer>> modList = modService.FindAllMod();
            R.setData(modList);
            R.setFlag(true);
        }catch (Exception e){
            R.setFlag(false);
            R.setErrorMsg("查询失败");
            e.printStackTrace();
        }

        return R;
    }
}
