package com.example.springboot.dao;

import com.example.springboot.entity.AdminOperateLog;
import com.example.springboot.entity.AdminOperateLogWithBLOBs;

public interface AdminOperateLogMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminOperateLogWithBLOBs record);

    int insertSelective(AdminOperateLogWithBLOBs record);

    AdminOperateLogWithBLOBs selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminOperateLogWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(AdminOperateLogWithBLOBs record);

    int updateByPrimaryKey(AdminOperateLog record);
}