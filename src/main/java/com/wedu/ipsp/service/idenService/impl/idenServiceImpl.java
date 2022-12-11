package com.wedu.ipsp.service.idenService.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wedu.ipsp.domain.ResultInfo;
import com.wedu.ipsp.domain.User;
import com.wedu.ipsp.domain.iden;
import com.wedu.ipsp.mapper.idenMapper;
import com.wedu.ipsp.service.idenService.idenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class idenServiceImpl extends ServiceImpl<idenMapper,iden> implements idenService {

    @Autowired
    private idenMapper idenMapper;

    @Override
    public IPage<iden> getPage(int currentPage, int pageSize) {
        IPage<iden> page = new Page(currentPage, pageSize);
        idenMapper.selectPage(page, null);
        return page;
    }

    @Override
    public ResultInfo findAlliden(int pageNum, int pageSize) {
        ResultInfo info = new ResultInfo();
        info.setFlag(true);
        //当前页 pagenum  当前页显示条数 pageSize
        PageHelper.startPage(pageNum, pageSize);
        try {
            List<iden> idens = idenMapper.findAllUser();
            PageInfo<iden> pageInfo = new PageInfo<iden>(idens);
            info.setData(pageInfo);
            System.out.println(idens);
        } catch (Exception e) {
            info.setFlag(false);
            info.setErrorMsg("查询失败");
            e.printStackTrace();
        }
        return info;
    }

}
