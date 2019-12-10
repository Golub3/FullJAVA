package golub;

import golub.entity.StudentDyplomer;
import golub.entity.Student;

public class Main {

    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 1, "123456");
        Student st2 = new Student("Maria", 5, "1254365");

        System.out.println(st1);
        System.out.println(st2);

        StudentDyplomer std1 = new StudentDyplomer("Happy new year!");
        StudentDyplomer std2 = new StudentDyplomer("Happy birthday!");

        st1.changeCourse(2);
        System.out.println(st1);

    }

}