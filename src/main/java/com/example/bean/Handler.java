package com.example.bean;

import java.lang.reflect.Method;

/**
 * 处理请求对象
 */
public class Handler {

    /**
     * 处理请求的Controller类
     */
    private Class<?> controllerClass;

    /**
     * Action方法
     */
    private Method actionMethod;

    public Handler(Class<?> controllerClass,Method actionMethod){
        this.controllerClass = controllerClass;
        this.actionMethod = actionMethod;
    }

    public Class<?> getControllerClass(){
        return controllerClass;
    }

    public Method getActionMethod() {
        return actionMethod;
    }
}
