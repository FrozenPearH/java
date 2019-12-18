package reflect;

import domain.Person;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 11:10
 */
public class ReflectDemo1 {
    /**
     * 获取Class对象的方式:
     * 1. Class . forName("全类名"):将字节码文件加载进内存，返回Class对象
     * 2.类名.class: 通过类名的属性class获取
     * 3.对象.getClass(): getClass()方法在0bject类中定义。
     */
    public static void main(String[] args) throws Exception {
        //1.Class . forName("全类名"):
        Class cls1 = Class.forName("domain.Person");
        System.out.println(cls1);
        //2.类名.class:
        Class cls2 = Person.class;
        System.out.println(cls2);
        //3.对象.getClass():
        Person person = new Person();
        Class cls3 = person.getClass();
        System.out.println(cls3);

        //三个对象相等
        System.out.println(cls1 == cls2);
        System.out.println(cls1 == cls3);
    }
}
