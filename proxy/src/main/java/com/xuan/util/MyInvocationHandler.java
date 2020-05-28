package com.xuan.util;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author shenxuan
 **/
public class MyInvocationHandler implements InvocationHandler {
    /*
    被代理对象
     */
    public Object target;


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start magic");
        return null;
    }

    public void setTarget(Object target) {
        this.target = target;
    }
}
