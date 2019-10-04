package com.xuan;

/**
 * @author xuan
 */
public class App {
    public static void main(String[] args) {
        MyMethod myMethod = new MyMethod();
        Thread instanceThread = new Thread(myMethod::instanceTest);
        Thread twoInstanceThread = new Thread(myMethod::twoInstanceTest);
        Thread staticThread = new Thread(MyMethod::staticMethodTest);
        Thread noramalThread = new Thread(myMethod::normalMethod);
        instanceThread.start();
        twoInstanceThread.start();
        staticThread.start();
        noramalThread.start();
    }
}
