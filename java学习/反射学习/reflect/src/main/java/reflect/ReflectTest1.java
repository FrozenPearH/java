package reflect;

import domain.Person;
import domain.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 17:20
 */
public class ReflectTest1 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setPersonType("测试");
        StudentService studentService = new StudentServiceImpl();
        Student student = studentService.getStudent(p);
        System.out.println(student);
    }
}
