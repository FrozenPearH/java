package reflect;

import annotation.Pro;

import java.lang.reflect.Method;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-18 10:56
 */
@Pro(className = "domain.Demo1", methodName = "show")
public class ReflectTest2 {
    public static void main(String[] args) throws Exception {
        //1.解析注解
        //1.1获取该类的字节码文件对象
        Class<ReflectTest2> reflectTest2Class = ReflectTest2.class;
        //2.获取上边的注解对象
        //其实就是在内存中生成了一个该注解的子类实现对象
        Pro annotation = reflectTest2Class.getAnnotation(Pro.class);
        //3.调用注解对象中定义的抽象方法，获取返回值
        String className = annotation.className();
        String methodName = annotation.methodName();
        System.out.println("className:  " + className + "      methodName:  " + methodName);
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
