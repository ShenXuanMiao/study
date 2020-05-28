package com.xuan.security.shiro;

import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.util.ByteSource;

public class MyCryptography {
    private static DefaultHashService hashService = null;

    private MyCryptography() {
    }


    private static synchronized void setHashService() {
        if (hashService == null) {
            hashService = new DefaultHashService(); //默认算法SHA-512
            hashService.setHashAlgorithmName("SHA-512");
            hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认这个
            hashService.setHashIterations(4); //生成Hash值的迭代次数
        }
    }

    public static String Cryptography(String password, String salt) {
        setHashService();
        HashRequest request = new HashRequest.Builder().setIterations(4).setSource(ByteSource.Util.bytes(password)).setSalt(ByteSource.Util.bytes(salt)).build();
        return hashService.computeHash(request).toHex();
    }

    public static String getSalt() {
        SecureRandomNumberGenerator randomNumberGenerator =
                new SecureRandomNumberGenerator();
        return randomNumberGenerator.nextBytes().toHex();
    }
}
