package com.example.springboot.dao;

import com.example.springboot.entity.TestUser;

public interface TestUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TestUser record);

    int insertSelective(TestUser record);

    TestUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TestUser record);

    int updateByPrimaryKey(TestUser record);

    /**
     * @description TODO 查询名称
     * @author zn
     * @date 2019/10/31 11:02
     * @param record
     * @return
     */
    TestUser selectUserByName(TestUser record);
}