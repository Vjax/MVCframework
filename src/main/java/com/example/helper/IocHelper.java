package com.example.helper;

import com.example.annotation.Inject;
import com.example.util.ArrayUtil;
import com.example.util.CollectionUtil;
import com.example.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * 找到beanMap中所有带有@Inject注解的变量
 * 通过反射赋值
 */
public final class IocHelper {

    static{
        //获取所有bean类与bean实例之间的映射关系
        Map<Class<?>,Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)){
            for (Map.Entry<Class<?>,Object>beanEntry : beanMap.entrySet()){
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)){
                    for (Field beanField : beanFields){
                        if (beanField.isAnnotationPresent(Inject.class)){
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null){
                                ReflectionUtil.setField(beanInstance,beanField,beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
