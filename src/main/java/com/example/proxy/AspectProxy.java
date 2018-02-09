package com.example.proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Method;

public abstract class AspectProxy implements Proxy{

    private static final Logger LOGGER = LoggerFactory.getLogger(AspectProxy.class);

    public Object doProxy(ProxyChain proxyChain) throws Throwable {
        Object result = null;
        Class<?> cls = proxyChain.getTargetClass();
        Method method = proxyChain.getTargetMethod();
        Object[] param = proxyChain.getMethodParams();

        begin();
        try {
            if (intercept(cls,method,param)){
                before(cls,method,param);
                result = proxyChain.doProxyChain();
                after(cls,method,param);
            } else {
                result = proxyChain.doProxyChain();
            }
        }catch (Exception e){
            LOGGER.error("proxy failure",e);
            error(cls,method,param);
            throw new RuntimeException(e);
        }finally {
            end();
        }

        return result;
    }

    public void begin(){
    }

    private boolean intercept(Class<?> cls, Method method,Object[] params) throws Throwable{
        return true;
    }

    public void before(Class<?> cls,Method method,Object[] params) throws Throwable{

    }

    public void after(Class<?> cls,Method method,Object[] params) throws Throwable{

    }

    public void error(Class<?> cls,Method method,Object[] params) throws Throwable{

    }

    public void end(){

    }
}
