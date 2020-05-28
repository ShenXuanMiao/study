import com.xuan.security.shiro.MyCryptography;
import com.xuan.security.shiro.SubjectManager;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.DefaultHashService;
import org.apache.shiro.crypto.hash.HashRequest;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void testAuthticator() {
        SubjectManager.login("classpath:myshiroTest.ini", "admin", "1234");
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        System.out.println(principalCollection.getPrimaryPrincipal());
        Assert.assertTrue(subject.isPermitted("sys:create"));
        Assert.assertTrue(subject.isPermitted("sys:update"));
        Assert.assertTrue(subject.hasRole("root"));
        Assert.assertTrue(subject.hasRole("root2"));

    }

    @Test
    public void getCryptographyPassword() {
        String salt = MyCryptography.getSalt();
        String cryptpgraphy = MyCryptography.Cryptography("1234", salt);
        System.out.println(salt);
        System.out.println(cryptpgraphy);
    }

    @Test
    public void testHashService() {
        DefaultHashService hashService = new DefaultHashService(); //默认算法SHA-512
        hashService.setHashAlgorithmName("SHA-512");
        hashService.setGeneratePublicSalt(true);//是否生成公盐，默认false
        hashService.setRandomNumberGenerator(new SecureRandomNumberGenerator());//用于生成公盐。默认就这个
        hashService.setHashIterations(1); //生成Hash值的迭代次数

        HashRequest request = new HashRequest.Builder()
                .setAlgorithmName("MD5").setSource(ByteSource.Util.bytes("hello"))
                .setSalt(ByteSource.Util.bytes("123")).setIterations(2).build();
        String hex = hashService.computeHash(request).toHex();
        System.out.println(hex);
    }

    @After
    public void tearDown() {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

    @Test
    public void testSE() {
        String str1 = "tz";
        String str4 = "hellow" + "tz";
        String str5 = "hellow";
        String str6 = str5 + str1;
        System.out.println(str4 == str6);//false
    }

    @Test
    public void testCollectionTypes() {
        Collection<String> collection = new ArrayList<>();
        collection.add("jok1");
        collection.add("jok2");
        collection.forEach(System.out::println);
    }

    @Test
    public void testCollectionTypes2() {
        Collection<String> collection = new ArrayList<>();
        collection.add("jok1");
        collection.add("jok2");
        Iterator<String> iterator = collection.iterator();
        iterator.forEachRemaining(System.out::println);
    }

    @Test
    public void testCollectionTypes3() {
        Collection<String> collection = new ArrayList<>();
        collection.add("jok1");
        collection.add("jok2");
        for (String next : collection) {
            System.out.println(next);
        }
    }

    @Test
    public void testCollectionTypes4() {
        Map<String, String> map = new HashMap<>();
        map.put("xuanmiao", "verysmart");
        map.put("yuewang", "sobeng");
        map.forEach((key, value) -> {
            System.out.print(key);
            System.out.print(" " + value + "\n");
        });
    }

    @Test
    public void testCollectionTypes5() {
        Map<String, String> map = new HashMap<>();
        map.put("xuanmiao", "verysmart");
        map.put("yuewang", "sobeng");
       for(Map.Entry<String,String> entry:map.entrySet()){
           System.out.println(entry.getKey());
        }
    }

    @Test
    public void testCollectionTypes6() {
        Map<String, String> map = new HashMap<>();
        map.put("xuanmiao", "verysmart");
        map.put("yuewang", "sobeng");
        for(Map.Entry<String,String> entry:map.entrySet()){
            System.out.println(entry.getKey());
        }
    }
}
