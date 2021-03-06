package reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 16:37
 */
public class ReflecTest {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //1.1创建Properties对象
        Properties properties = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = ReflecTest.class.getClassLoader();
        InputStream resourceAsStream = classLoader.getResourceAsStream("pro.properties");
        properties.load(resourceAsStream);

        //2.获取配置文件中定义的数据
        String className = properties.getProperty("className");
        String methodName = properties.getProperty("methodName");

        //3.加载该类进内存
        Class<?> cls = Class.forName(className);

        //4.创建对象
        Object obj = cls.newInstance();

        //5.获取方法对象
        Method method = cls.getMethod(methodName);

        //6.执行方法
        method.invoke(obj);
    }
}
