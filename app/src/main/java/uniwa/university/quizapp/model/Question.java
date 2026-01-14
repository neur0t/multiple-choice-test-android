package uniwa.university.quizapp.model;

import java.util.List;

public class Question {

    private String text;
    private List<String> answers;
    private int correctIndex;
    private int imageResId;

    public Question(String text, List<String> answers, int correctIndex, int imageResId) {
        this.text = text;
        this.answers = answers;
        this.correctIndex = correctIndex;
        this.imageResId = imageResId;
    }

    public String getText() {
        return text;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public int getCorrectIndex() {
        return correctIndex;
    }

    public int getImageResId() {
        return imageResId;
    }
}