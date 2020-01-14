package domain;


import annotation.Mds;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 11:12
 */
@Mds(prefix = "person")
public class Person {
    private String personType;
    private String name;
    private String age;

    public String a;
    protected String b;
    String c;
    private String d;

    public void eat() {
        System.out.println("eating...");
    }

    public void eat(String food) {
        System.out.println("eating..." + food);
    }

    public Person(String name, String age, String a, String b, String c, String d) {
        this.name = name;
        this.age = age;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "personType='" + personType + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                ", d='" + d + '\'' +
                '}';
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

}
