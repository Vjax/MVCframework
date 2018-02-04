package com.example.helper;

import com.example.ConfigConstant;
import com.example.util.PropUtil;

import java.util.Properties;

public final class ConfigHelper {

    /**
     * 读取配置项的类
     */
    private static final Properties CONFIG_PROPS= PropUtil.loadProps(ConfigConstant.CONFIG_FILE);

    /**
     * 获取JDBC驱动
     */
    public static String getJdbcDriver(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_DRIVER);
    }

    /**
     * 获取JDBC URL
     */
    public static String getJdbcUrl(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_URL);
    }

    /**
     * 获取JDBC用户名
     */
    public static String getJdbcUsername(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_USERNAME);
    }

    /**
     * 获取JDBC密码
     */
    public static String getJdbcPassword(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.JDBC_PASSWORD);
    }

    /**
     * 获取应用基础包名
     */
    public static String getAppBasePackage(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.APP_BASE_PACKAGE);
    }

    /**
     * 获取应用jsp路径
     */
    public static String getAppJspPath(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/WEB_INF/view/");
    }

    /**
     * 获取应用静态资源路径
     */
    public static String getAppAssetPath(){
        return PropUtil.getString(CONFIG_PROPS,ConfigConstant.APP_JSP_PATH,"/asset/");
    }
}
