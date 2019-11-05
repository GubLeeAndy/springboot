package com.example.springboot.dao;

import com.example.springboot.entity.AdminSystemRelation;

public interface AdminSystemRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminSystemRelation record);

    int insertSelective(AdminSystemRelation record);

    AdminSystemRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(AdminSystemRelation record);

    int updateByPrimaryKey(AdminSystemRelation record);
}