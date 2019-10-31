package com.example.springboot.impl;

import com.example.springboot.redis.RedisUtil;
import com.example.springboot.dao.TestUserMapper;
import com.example.springboot.entity.TestUser;
import com.example.springboot.service.TestUserService;
import com.example.springboot.utils.CodeEnum;
import com.example.springboot.utils.Result;
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
    public TestUser seletUserName(TestUser testUser) {
        return testUserMapper.selectUserByName(testUser);
    }
}
