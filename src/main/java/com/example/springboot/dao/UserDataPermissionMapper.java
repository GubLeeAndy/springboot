package com.example.springboot.dao;

import com.example.springboot.entity.UserDataPermission;

public interface UserDataPermissionMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserDataPermission record);

    int insertSelective(UserDataPermission record);

    UserDataPermission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserDataPermission record);

    int updateByPrimaryKey(UserDataPermission record);
}