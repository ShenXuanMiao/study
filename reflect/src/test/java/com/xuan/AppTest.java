package com.xuan;


import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * 反射获取的是运行时类型的Class对象
     */
    @Test
    public void reflectRuntime() {
        CompileClass compileClass = new RuntimeClass();
        Class<? extends CompileClass> aClass = compileClass.getClass();
        assertEquals("com.xuan.RuntimeClass", aClass.getName());
    }

    /**
     * 反射与多态
     */
    @Test
    public void reflectPolymorphism() {
        //多态对象
        CompileClass polymorphismObj = new RuntimeClass();
        //多态对象获得Class对象
        Class<? extends CompileClass> aClass = polymorphismObj.getClass();
        try {
            Method talk = aClass.getMethod("talk");
            CompileClass compileClass = aClass.newInstance();
            talk.invoke(polymorphismObj);
            talk.invoke(compileClass);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            fail("找不到方法");
        } catch (IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
            fail("ssss");
        }

    }

    @Test
    void testAccessModifiers() {
        //子类对象
        RuntimeClass runtimeObj = new RuntimeClass();
        //通过子类对象获得Class对象
        Class<? extends RuntimeClass> runtimeClass = runtimeObj.getClass();
        Method sayRuntimeClass = null;
        try {
            sayRuntimeClass = runtimeClass.getDeclaredMethod("say");
//            sayRuntimeClass.setAccessible();
            sayRuntimeClass.invoke(runtimeObj) ;
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
