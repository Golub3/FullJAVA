
import golub.annotation.MyAnnotation;
import golub.entity.IStudent;
import golub.entity.MyInvocationHandler;
import golub.entity.StudentDyplomer;
import golub.entity.Student;
import lombok.SneakyThrows;
import org.junit.Test;
import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Tester {

    @Test
    @SneakyThrows
    public void shouldCallMethodWithAnnotations() {
        Student st1 = createStudent();
        for (Method method : st1.getClass().getMethods()) {
            if (method.isAnnotationPresent(MyAnnotation.class)) {
                method.invoke(st1);
            }
        }

        assertEquals(1, st1.getCourse());

    }

    @Test
    public void shouldCallTextWindowClass() {
        StudentDyplomer std1 = new StudentDyplomer();

        String expected = std1.getClass().getSimpleName();

        assertEquals("StudentDyplomer", expected);
    }


    @Test
    public void shouldCallMethodsWithAccessSpecifiersAndParameterTypes() {
        Student stud = createStudent();

        Arrays.stream(stud.getClass().getDeclaredMethods())
                .map(method -> Modifier.toString(method.getModifiers()) +
                        " " + method.getReturnType().getName() +
                        " " + method.getName() +
                        "(" + getParameters(method) + ")")
                .forEach(System.out::println);

        int actual = stud.getClass().getDeclaredMethods().length;
        assertEquals(10, actual);
    }


    @Test
    public void shouldCallSuperclassName(){
        StudentDyplomer student = new StudentDyplomer();

        String superClass = student.getClass().getSuperclass().getSimpleName();

        assertEquals( "Student", superClass);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionProxy(){
        Student window = createStudent();

        IStudent windowProxy = (IStudent) Proxy.newProxyInstance(
                Student.class.getClassLoader(),
                Student.class.getInterfaces(),
                new MyInvocationHandler(window));

        int course = windowProxy.getCourse();
        System.out.println(course);

        windowProxy.setCourse(3);
    }

    private String getParameters(Method method) {
        return Arrays.stream(method.getParameters())
                .map(parameter -> parameter.getType().getName() + " " + parameter.getName())
                .collect(Collectors.joining(","));
    }


    private Student createStudent() {
        return Student.builder()
                .name("Petro")
                .course(6)
                .indNumber("121232")
                .build();
    }

}