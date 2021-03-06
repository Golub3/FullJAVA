package golub.entity;

import golub.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor

@Builder

public class Student implements IStudent{

    private String name;
    private int course;
    private String indNumber;

//    private Student(){
//        this.name = "Vitaliy";
//        this.course = 3;
//        this.indNumber = "12312323";
//    }
//
//    public Student(String name, int course, String indNumber){
//        this.name = name;
//        this.course = course;
//        this.indNumber = indNumber;
//    }




    public void changeCourse(int newCourse){
        course = newCourse;
    }

    @MyAnnotation
    public void changeCourseToFirst(){
        course = 1;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getCourse(){
        return course;
    }

    @Override
    public String getIndNumber(){
        return indNumber;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setCourse(int course) {
        this.course = course;
    }

    @Override
    public void setIndNumber(String indNumber) {
        this.indNumber = indNumber;
    }

    @Override
    public String toString() {
        return "Student: " + name + " \nCourse: " + course + " \nIdentification number: " + indNumber;
    }

}
