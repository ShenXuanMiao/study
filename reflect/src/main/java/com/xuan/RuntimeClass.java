package com.xuan;

/**
 * @author xuan
 */
public class RuntimeClass extends CompileClass {
    private void Dsay() {
        System.out.println("子类特有的方法");
    }
    public void talk() {
        System.out.println("子类重写父类的方法");
    }
}
