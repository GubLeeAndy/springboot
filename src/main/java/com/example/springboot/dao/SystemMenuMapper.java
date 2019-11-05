package com.example.springboot.dao;

import com.example.springboot.entity.SystemMenu;

public interface SystemMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemMenu record);

    int insertSelective(SystemMenu record);

    SystemMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemMenu record);

    int updateByPrimaryKey(SystemMenu record);
}