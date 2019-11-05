package com.example.springboot.dao;

import com.example.springboot.entity.AdminMenuRelation;

public interface AdminMenuRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminMenuRelation record);

    int insertSelective(AdminMenuRelation record);

    AdminMenuRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminMenuRelation record);

    int updateByPrimaryKey(AdminMenuRelation record);
}