package com.wedu.ipsp.service.tableDataService;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.tableData;




public interface tableDataService extends IService<tableData> {

    ResultInfo findTabData();
    ResultInfo ADD(tableData Data);
}
