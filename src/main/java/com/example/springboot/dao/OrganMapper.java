package com.example.springboot.dao;

import com.example.springboot.entity.Organ;

public interface OrganMapper {
    int deleteByPrimaryKey(String id);

    int insert(Organ record);

    int insertSelective(Organ record);

    Organ selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Organ record);

    int updateByPrimaryKey(Organ record);
}