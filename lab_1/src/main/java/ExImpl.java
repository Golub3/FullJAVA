import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExImpl implements Exam {

    public Ticket getTicket(List<Variant> variants) {

        List<Question> questionsInTicket = new ArrayList<>();

        for (Variant variant: variants) {
            questionsInTicket.add(variant.getRandomQuestion());
        }

        return new Ticket(questionsInTicket);
    }

}
