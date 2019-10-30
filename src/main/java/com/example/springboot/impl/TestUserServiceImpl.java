package com.example.springboot.impl;

import com.example.springboot.config.redis.RedisUtil;
import com.example.springboot.dao.TestUserMapper;
import com.example.springboot.entity.TestUser;
import com.example.springboot.service.TestUserService;
import com.example.springboot.utils.UID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description: TODO()
 * @author: zn
 * @date: Created in 2019/10/29 14:30
 * @version:
 */
@Service
public class TestUserServiceImpl implements TestUserService {

    @Autowired
    private TestUserMapper testUserMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String hello() {
        TestUser testUser = new TestUser();
        testUser.setId(UID.generateID());
        testUser.setName("测试");
        testUserMapper.insertSelective(testUser);
        redisUtil.set("wudi","jimo");
        return "成功";
    }

    @Override
    public String delete() {
        testUserMapper.deleteByPrimaryKey("04bdb0db24bc4d4f8dfe17846485e5b1");
        return "成功";
    }
}
