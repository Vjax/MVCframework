package com.example;

import com.example.annotation.Controller;
import com.example.helper.*;
import com.example.util.ClassUtil;

import java.util.LinkedList;
import java.util.Queue;

public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                AopHelper.class,
                ControllerHelper.class,
                IocHelper.class
        };
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
