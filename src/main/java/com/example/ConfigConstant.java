package com.example;

public interface ConfigConstant {
    /**
     * property文件的常量
     */
    String CONFIG_FILE = "config.properties";

    String JDBC_DRIVER = "com.example.jdbc.driver";
    String JDBC_URL = "com.example.jdbc.url";
    String JDBC_USERNAME = "com.example.jdbc.username";
    String JDBC_PASSWORD = "com.example.jdbc.password";

    //项目基础包名
    String APP_BASE_PACKAGE = "com.example.app.base_package";
    //jsp基础路径
    String APP_JSP_PATH = "com.example.app.jsp_path";
    //静态资源路径
    String APP_ASSET_PATH = "com.example.app.asset_path";
}
