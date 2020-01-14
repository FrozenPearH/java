package domain;

/**
 * @author lizhang.huang@hand-china.com
 * @date 2019-12-17 16:32
 */
public class Student {
    private String studentType;

    public void sleep() {
        System.out.println("sleeping.......");
    }

    public Student() {
    }

    public Student(String studentType) {
        this.studentType = studentType;
    }

    public String getStudentType() {
        return studentType;
    }

    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentType='" + studentType + '\'' +
                '}';
    }
}
