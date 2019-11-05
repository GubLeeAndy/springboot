package com.example.springboot.dao;

import com.example.springboot.entity.UserLoginFlag;

public interface UserLoginFlagMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserLoginFlag record);

    int insertSelective(UserLoginFlag record);

    UserLoginFlag selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserLoginFlag record);

    int updateByPrimaryKey(UserLoginFlag record);
}