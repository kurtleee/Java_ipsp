package com.wedu.ipsp.service.idenService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.iden;



public interface idenService extends IService<iden> {
    IPage<iden> getPage(int currentPage, int pageSize);

    ResultInfo findAlliden(int pageNum,int pageSize);


//    ResultInfo findAll(int pageNum, int pageSize);
}
