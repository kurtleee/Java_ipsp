package com.wedu.ipsp.domain;


import lombok.Data;

import java.util.Date;

@Data
public class iden {
    private int idenId;
    private String idenNumber;
    private int dataTempId;
    private int showTempId;
    private String idenUrl;
    private Date operTime;//最近操作时间
    private int idenItemData;

}
