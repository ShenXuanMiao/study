package com.xuan;

/**
 * @author xuan
 */
public class RecursionMethod {
    private int start=1;
    private int before=1;
    private int after=1;
    public int get(int i){
        System.out.println("递归函数开始:"+start);
        start++;
        if (i<0)return 10;
        System.out.println("递归函数调用自身之前:"+before);
        before++;
        int value = get(i - 1) + get(i - 2);
        System.out.println("递归函数调用自身之后:"+after);
        after++;
        return value;
    }
}
