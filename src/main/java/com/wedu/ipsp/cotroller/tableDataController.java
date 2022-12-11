package com.wedu.ipsp.cotroller;


import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.tableData;
import com.wedu.ipsp.mapper.tableDataMapper;
import com.wedu.ipsp.mapper.tempDataMapper;
import com.wedu.ipsp.service.tableDataService.tableDataService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.login.CredentialNotFoundException;

@RestController
@RequestMapping("/tableData/")
@Slf4j
public class tableDataController {

    @Autowired
    private tableDataService tabledataservice;
    private tempDataMapper tempDataMapper;
    @PostMapping("add")
    public ResultInfo add(@RequestBody tableData tabledata){
        ResultInfo add = tabledataservice.ADD(tabledata);
        return add;
    }
    @DeleteMapping("delete")
    public ResultInfo Delete(@RequestBody tableData tab){
        boolean b = tabledataservice.removeById(tab);

        return new ResultInfo(b);

    }


   @GetMapping("getAll")
    public ResultInfo findTableData(){
        ResultInfo tableData = tabledataservice.findTabData();

        return tableData;
    }


}
