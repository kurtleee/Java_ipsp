package com.wedu.ipsp.domain;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
public class tableData {
    private  int tempId;
    private int typeId;
    private String typeName;
    private String tempNumber;
    private String tempDesc;
    private int tempDataId;

    @TableField(exist = false)
    private List<tempData> tempData=new ArrayList();



}
