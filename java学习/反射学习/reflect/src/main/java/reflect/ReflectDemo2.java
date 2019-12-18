package reflect;

import domain.Person;

import java.lang.reflect.Field;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 14:06
 */
public class ReflectDemo2 {
    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;

        //1、Field[] getFields() :获取所有publ ic修饰的成员变址
        Field[] fields = personClass.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }
        System.out.println("```````````````````");

        //2、Field getField(String name ) ：获取指定名称的public修饰的成员变中
        Field a = personClass.getField("a");
        System.out.println(a);
        //获取成员变量a的值
        Person p = new Person();
        Object value = a.get(p);
        System.out.println(value);
        //设置a的值
        a.set(p, "测试");
        System.out.println(p);
        System.out.println("=============");

        //3、Field[] getDeclaredFields() ：获取所有的成贝变量，不考虑修饰符
        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField);
        }

        //4、Field getDeclaredField(String name)
        Field d = personClass.getDeclaredField("d");
        //忽略访问权限修饰符的安全检查    暴力反射
        d.setAccessible(true);
        Object value1 = d.get(p);
        System.out.println(value1);
    }
}
