package com.example.springboot.dao;

import com.example.springboot.entity.SystemOrganRelation;

public interface SystemOrganRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(SystemOrganRelation record);

    int insertSelective(SystemOrganRelation record);

    SystemOrganRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(SystemOrganRelation record);

    int updateByPrimaryKey(SystemOrganRelation record);
}