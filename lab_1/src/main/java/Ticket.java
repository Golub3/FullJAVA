import java.util.List;

public class Ticket {

    private List<Question> questions;

    public Ticket(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }


    public String toString() {
        return "Ticket:" + questions;
    }
}