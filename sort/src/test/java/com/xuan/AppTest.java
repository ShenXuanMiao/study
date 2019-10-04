package com.xuan;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {

        List<String> list=new ArrayList<>();
        list.add("123");
        list.add("234");
        String s = list.set(1, "aaaa");
        int[] ints = {1, 2, 3};
        System.out.println(list);
        System.out.println(s);
    }
}
