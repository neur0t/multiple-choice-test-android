package uniwa.university.quizapp.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import uniwa.university.quizapp.model.Question;

public class QuestionRepository {
    private static QuestionRepository instance;
    private List<Question> questions;

    private QuestionRepository() {
        questions = new ArrayList<>();
        loadQuestions();
    }

    public static QuestionRepository getInstance() {
        if (instance == null) {
            instance = new QuestionRepository();
        }
        return instance;
    }

    private void loadQuestions() {
        // εδώ ΘΑ βάλουμε ερωτήσεις στο επόμενο στάδιο
    }

    public List<Question> getRandomQuestions(int count) {
        Collections.shuffle(questions);
        return questions.subList(0, count);
    }
}
