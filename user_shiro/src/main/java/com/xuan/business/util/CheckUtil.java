package com.xuan.business.util;

import com.xuan.business.exception.CheckException;

/**
 * 校验工具类
 */
public class CheckUtil {

    /**
     * 如果传入布尔表达式为false，则抛出CheckException异常
     *
     * @param condition 需要校验的布尔表达式
     * @param msgKey    抛出异常的解释信息
     * @return :void
     **/
    public static void check(boolean condition, String msgKey) {
        if (condition) {
            fail(msgKey);
        }
    }

    /**
     * 如果传入字符串为null或为空，则抛出CheckException异常
     * @param str    需要校验的字符串
     * @param msgKey 抛出异常的解释信息
     * @return :void
     **/
    public static void notEmpty(String str, String msgKey) {
        if (str == null || str.isEmpty()) {
            fail(msgKey);
        }
    }

    /**
     * 如果传入对象为null，则抛出CheckException异常
     * @param obj    需要校验的对象
     * @param msgKey 抛出异常的解释信息
     * @return :void
     **/
    public static void notNull(Object obj, String msgKey) {
        if (obj == null) {
            fail(msgKey);
        }
    }

    /**
     * 如果传入int类型数据为零，则抛出CheckException异常
     * @param num    需要校验的int数据
     * @param msgKey 抛出异常的解释信息
     * @return :void
     **/
    public static void isZero(int num, String msgKey) {
        if (num == 0) {
            fail(msgKey);
        }
    }

    /**
     * 抛出CheckException异常
     * @return :void
     * @param: [msgKey]抛出异常的详细信息
     **/
    private static void fail(String msgKey) {
//        String log="异常CheckException:{},类:{},参数{}";
//        logger.error(log,msgKey,obj);
        throw new CheckException(msgKey);
    }
}
