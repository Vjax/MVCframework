package com.example;

import com.example.annotation.Controller;
import com.example.helper.BeanHelper;
import com.example.helper.ClassHelper;
import com.example.helper.ControllerHelper;
import com.example.helper.IocHelper;
import com.example.util.ClassUtil;

public final class HelperLoader {

    public static void init(){
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                ControllerHelper.class,
                IocHelper.class
        };
        for (Class<?> cls : classList){
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}
