package com.wedu.ipsp.domain;

import lombok.Data;
import org.springframework.boot.SpringApplication;

import javax.swing.*;
@Data
public class tempData {
    private int tempDataId;
    private String type;
    private String title;
    private String value;
    private int source;
}
