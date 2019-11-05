package com.example.springboot.dao;

import com.example.springboot.entity.AdminMenu;

public interface AdminMenuMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminMenu record);

    int insertSelective(AdminMenu record);

    AdminMenu selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminMenu record);

    int updateByPrimaryKey(AdminMenu record);
}