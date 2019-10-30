package com.example.springboot.utils;

/**
 * @description: TODO(生成32位UUID)
 * @author: zn
 * @date: Created in 2019/10/29 14:34
 * @version:
 */
public class UID {
    public static String generateID(){
        return java.util.UUID.randomUUID().toString().replaceAll("-","");
    }
}
