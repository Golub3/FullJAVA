import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExImplTest {

    private Exam exam = new ExImpl();
    private List<Variant> variants;


    @Before
    public void setUp() throws Exception {
        List<Question> questionsFirst = new ArrayList<>();
        List<Question> questionsSecond = new ArrayList<>();
        List<Question> questionsThird = new ArrayList<>();

        questionsFirst.add(new Question("Question A"));
        questionsFirst.add(new Question("Question B"));
        questionsFirst.add(new Question("Question C"));

        questionsSecond.add(new Question("Question D"));
        questionsSecond.add(new Question("Question E"));
        questionsSecond.add(new Question("Question F"));

        questionsThird.add(new Question("Question G"));
        questionsThird.add(new Question("Question H"));
        questionsThird.add(new Question("Question I"));

        Variant variant1 = new Variant(questionsFirst, "1");
        Variant variant2 = new Variant(questionsSecond, "2");
        Variant variant3 = new Variant(questionsThird, "3");

        List<Variant> variants = new ArrayList<>();

        variants.add(variant1);
        variants.add(variant2);
        variants.add(variant3);

        this.variants = variants;
    }

    @Test
    public void checkNumberOfQuestionsInTicketTest() {

        int expectedSize = 3;

        int result = exam.getTicket(variants).getQuestions().size();
        for(int i = 1; i<= 10; i++) {
            System.out.print(i+". ");
            System.out.println(exam.getTicket(variants));
        }
        Assert.assertEquals(expectedSize, result);

    }
}