package com.xuan;


import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */

public class AppTest {

   @BeforeAll
    static void testBeforeAll() {
       System.out.println("@BeforeAll");
   }
    @BeforeEach
    void testBeforeEach() {
        System.out.println("@BeforeEach");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    void test1() {
        System.out.println("test1");
    }

    @Test
    void test2() {
        System.out.println("test2");
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    void test3(){
        Assumptions.assumeTrue(false);
        System.out.println("假设失败");
    }


}
