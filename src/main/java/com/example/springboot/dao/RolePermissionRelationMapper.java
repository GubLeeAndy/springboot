package com.example.springboot.dao;

import com.example.springboot.entity.RolePermissionRelation;

public interface RolePermissionRelationMapper {
    int deleteByPrimaryKey(String id);

    int insert(RolePermissionRelation record);

    int insertSelective(RolePermissionRelation record);

    RolePermissionRelation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(RolePermissionRelation record);

    int updateByPrimaryKey(RolePermissionRelation record);
}