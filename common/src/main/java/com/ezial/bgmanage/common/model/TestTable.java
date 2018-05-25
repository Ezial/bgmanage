package com.ezial.bgmanage.common.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TestTable implements Serializable {
    private static final long serialVersionUID = 499099250654738192L;

    private Long id;

    private String name;
}
