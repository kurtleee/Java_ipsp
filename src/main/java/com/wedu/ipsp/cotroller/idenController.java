package com.wedu.ipsp.cotroller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.pagehelper.PageInfo;
// import com.sun.org.apache.regexp.internal.RE;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.domain.iden;

import com.wedu.ipsp.service.idenService.idenService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.UpdateProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

@RestController
@RequestMapping("/iden/")
@Slf4j
public class idenController {
    @Autowired
    private idenService idenService;

    @PostMapping("addIden")
    public ResultInfo addIden(@RequestBody iden I){
        boolean save = idenService.save(I);
        return new ResultInfo(save);
    }
    @DeleteMapping("deleteIden")
    public ResultInfo deleteIden(@RequestBody iden I){
        boolean b = idenService.removeById(I);
        return new ResultInfo(b);
    }
    @PutMapping("updateIden")
    public ResultInfo updateIden(@RequestBody iden I){
        boolean b = idenService.updateById(I);
        return new ResultInfo(b);
    }

    @GetMapping("getAllIdens/")
    public ResultInfo findAlliden(@RequestParam(value = "pageNum",required = false,defaultValue = "1")int pageNum,
                                  @RequestParam(value = "pageSize",required = false,defaultValue = "5")int pageSize) {
            log.info("请求以响应");
        ResultInfo resultInfo = idenService.findAlliden(pageNum,pageSize);
        log.info("分页查询");
        return resultInfo;
    }
}
