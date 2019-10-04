package com.xuan.study;

/**
 * @author xuan
 */
public class MyBeanFactory {
    public static MyBean getInstance(String name){
        return new MyBean();
    }


}
