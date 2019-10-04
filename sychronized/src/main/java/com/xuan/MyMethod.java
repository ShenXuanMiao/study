package com.xuan;

/**
 * @author xuan
 */
public class MyMethod {

    public synchronized void   instanceTest(){
        System.out.println("instance方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("instance方法结束");
    }
    public synchronized void   twoInstanceTest(){
        System.out.println("相同instance方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("相同instance方法结束");
    }
    public static synchronized void staticMethodTest() {
        System.out.println("static方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static方法结束");
    }

    public void normalMethod() {
        System.out.println("normal方法开始");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("normal方法结束");
    }

}
