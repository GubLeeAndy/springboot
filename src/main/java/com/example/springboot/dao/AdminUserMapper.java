package com.example.springboot.dao;

import com.example.springboot.entity.AdminUser;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminUser record);

    int insertSelective(AdminUser record);

    AdminUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminUser record);

    int updateByPrimaryKey(AdminUser record);
}