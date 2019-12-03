package golub.entity;
import golub.annotation.MyAnnotation;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString

public class StudentDyplomer extends Student{

    private String theme;


    @MyAnnotation
    public void changeTheme(String newTheme){
        theme = newTheme;
    }

}
