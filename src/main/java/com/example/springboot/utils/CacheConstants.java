package com.example.springboot.utils;

/**
 * @ClassName: CacheConstants
 * @Description: TODO(缓存常量)
 */
public class CacheConstants {
    /**
     * 毫秒
     */
    public static int MS=1000;

    /**
     * 时
     */
    public static int H=3600;

    /**
     * 天
     */
    public static int D=24;

    /**
     * shiro-redis 用户session缓存key
     */
    public static String SHIRO_REDIS_CACHE="shiro_redis_cache";
    public static String SHIRO_SESSION="shiro:session:%s";

    /**
     * shiro cookie时间1小时
     */
    public static int SHIRO_SESSION_MS = H * MS;

    /**
     * shiro用户对象缓存1小时
     */
    public static int USER_DATA_TTL = H;
    public static String KEY_USER_DATA="shiro:cache:shiro_user:%s";



    /**
     * 测试key
     */
    public static int DATA_TTL = D * H;
    public static String KEY_DATA="data";

    /**
     * 用户角色
     */
    public static int ROLE_BY_USERID_AND_APPID_TTL = D * H;
    public static String KEY_ROLE_BY_USERID_AND_APPID = "roleByUserIdAppId{%s,%s}";

    /**
     * 用户角色
     */
    public static int USER_PERMIS_BY_USERID_APPID_TTL = D * H;
    public static String KEY_USER_PERMIS_BY_USERID_APPID = "userPermission{%s,%s}";

    /**
     * 用户信息
     */
    public static int USER_INFO_BY_USERNAME_TTL = D * H;
    public static String KEY_USER_INFO_BY_USERNAME="getUserByUserName{%s}";



    /**
     * @ClassName:
     * @Description: TODO(ESB服务相关缓存key)
     * @author gangyu2
     * @date 2019年7月23日 下午4:28:45
     */
    public interface ESB{
        /**
         * 动态路由
         */
        public static final String GATEWAY_ROUTES = "geteway_routes";

        /**
         * 黑名单缓存
         */
        public static final String BALK_LIST="blakList";

        /**
         * 字典编码缓存
         */
        public static final String DICT_CODE="dictCode{%s}";

        /**
         * 服务名称缓存
         */
        public static final String SERVER_NAME="serverName";

        /**
         * 监控信息缓存
         */
        public static final String MONITOR_CACHE="monitorCache{%s}";

        /**
         * 服务授权缓存
         */
        public static final int SERVER_AUTH_INFO_TTL=  D * H ;
        public static final String SERVER_AUTH_INFO="serverAuthInfo{%s}";

        /**
         * 服务信息
         */
        public static final int SERVER_INFO_TTL=  D * H ;
        public static final String SERVER_INFO="serverInfo{%s}";

        /**
         * 服务限制输出参数
         */
        public static final int SERVER_LIMIT_OUT_PARAM_TTL=  D * H ;
        public static final String SERVER_LIMIT_OUT_PARAM="limitOutParam{%s}";
    }


    /**
     * @ClassName: SSO
     * @Description: TODO(SSO服务相关缓存key)
     * @author gangyu2
     * @date 2019年9月12日 下午3:17:47
     *
     */
    public interface SSO{

        /**
         * 认证中心管理员key
         */
        public static final String ADMIN_USER = "admin{%s}";
        /**
         * 系统用户key
         */
        public static final String USER = "user{%s}";

        /**
         *导入用户数据缓存key
         */
        public static final int IMPORT_USER_DATA_TTL= H ;
        public static final String IMPORT_USER_DATA="userdata{%s}";
    }
}
