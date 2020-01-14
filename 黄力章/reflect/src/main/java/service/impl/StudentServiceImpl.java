package service.impl;

import annotation.Mds;
import domain.Student;
import service.StudentService;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 17:16
 */
public class StudentServiceImpl implements StudentService {
    public Student getStudent(Object object) {
        Student student = new Student();
        Class<?> cls = object.getClass();
        //A.isAnnotationPresent(B.class);  判断 B类型的注解是否在A类上。
        boolean annotationPresent = cls.isAnnotationPresent(Mds.class);
        if (annotationPresent) {
            Mds annotation = cls.getAnnotation(Mds.class);
            String prefix = annotation.prefix();
            try {
                setFields(student, object, prefix);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return student;
    }

    private void setFields(Student student, Object object, String prefix) throws Exception {
        Class<?> cls = object.getClass();
        Field personType = cls.getDeclaredField(prefix + "Type");
        personType.setAccessible(true);
        student.setStudentType((String)personType.get(object));
    }

}