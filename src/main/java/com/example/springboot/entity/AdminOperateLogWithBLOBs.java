package com.example.springboot.entity;

import java.io.Serializable;

public class AdminOperateLogWithBLOBs extends AdminOperateLog implements Serializable {
    private String originalVal;

    private String newVal;

    private static final long serialVersionUID = 1L;

    public String getOriginalVal() {
        return originalVal;
    }

    public void setOriginalVal(String originalVal) {
        this.originalVal = originalVal == null ? null : originalVal.trim();
    }

    public String getNewVal() {
        return newVal;
    }

    public void setNewVal(String newVal) {
        this.newVal = newVal == null ? null : newVal.trim();
    }
}