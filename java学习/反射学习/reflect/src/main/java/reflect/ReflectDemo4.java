package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 14:06
 */
public class ReflectDemo4 {
    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;

        /**
         * - Method[] getMethods()
         * - Method getMethod(String name, 类<?>... parameterTypes)
         */
        //获取指定名称的方法
        Method eat = personClass.getMethod("eat");
        Person person = new Person();
        //执行方法
        eat.invoke(person);

        Method eat1 = personClass.getMethod("eat", String.class);
        eat1.invoke(person, "汉堡");

        //获取所有public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
            System.out.println(method.getName());
        }
        /** - Method[] getDeclaredMethods()
         * - Method getDeclaredMethod(string name, 类<?>... parameterTypes )
         */
        //获取类名
        System.out.println(personClass.getName());

    }
}
