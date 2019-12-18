package reflect;

import domain.Person;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 14:06
 */
public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        //0、获取Person的Class对象
        Class personClass = Person.class;

        /**
         * - Constructor<?>[] getConstructors()
         */
        Constructor constructor = personClass.getConstructor();
        System.out.println(constructor);
        //使用空参构造创建对象
        Object person = constructor.newInstance();
        System.out.println(person);
        //简化
        Object o = personClass.newInstance();
        System.out.println(o);
        System.out.println("==============");
         /**
         * - Constructor<T> getConstructor(类<?>... parameterTypes )
         */
        Constructor constructor1 = personClass.getConstructor(String.class, String.class);
        System.out.println(constructor1);
        //创建对象
        Object person1 = constructor1.newInstance("张三", "3");
        System.out.println(person1);
        /**
         * - Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
         */
        /**
         * - Constructor<?>[] getDeclaredConstructors()
         */

    }
}
