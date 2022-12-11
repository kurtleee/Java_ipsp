package com.wedu.ipsp.service.tableDataService.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.tableData;
import com.wedu.ipsp.domain.tempData;
import com.wedu.ipsp.mapper.tableDataMapper;
import com.wedu.ipsp.mapper.tempDataMapper;
import com.wedu.ipsp.service.tableDataService.tableDataService;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class tableDataServiceImpl extends ServiceImpl<tableDataMapper, tableData> implements tableDataService {
@Autowired
private tableDataMapper tableDataMapper;
@Autowired
private tempDataMapper tempdatamapper;

@Override
    public ResultInfo findTabData() {
    ResultInfo resultInfo = new ResultInfo();
    try {
        List<tableData> tableDataList = tableDataMapper.selectall();
        System.out.println(tableDataList);
        for (tableData data : tableDataList) {
            List<tempData> tempData = tempdatamapper.selectByFrom(data.getTempDataId());
            data.setTempData(tempData);
        resultInfo.setData(tableDataList);
        }
    }catch (Exception E){
        resultInfo.setFlag(false);
        resultInfo.setErrorMsg("查询失败");
        E.printStackTrace();
    }

    return resultInfo;
    }

    @Override
    public ResultInfo ADD(tableData Data) {

        List<tempData> tempdata = Data.getTempData();
        for (int i = 0; i < tempdata.size(); i++) {
             tempdatamapper.insert(tempdata.get(i));
        }
        int insert = tableDataMapper.insert(Data);
        if (insert>0){
            return new ResultInfo(true);
        }
        else
            return new ResultInfo(false);

    }
}
