package uniwa.university.quizapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

import uniwa.university.quizapp.R;
import uniwa.university.quizapp.data.QuestionRepository;
import uniwa.university.quizapp.model.Question;

public class QuizActivity extends AppCompatActivity {

    private ImageView questionImageView;
    private TextView questionTextView;
    private RadioGroup answersRadioGroup;
    private Button nextButton;


    private List<Question> questions;
    private int currentIndex = 0;
    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        questionTextView = findViewById(R.id.questionTextView);
        answersRadioGroup = findViewById(R.id.answersRadioGroup);
        nextButton = findViewById(R.id.nextButton);
        questionImageView = findViewById(R.id.questionImageView);

        questions = QuestionRepository.getInstance().getRandomQuestions(
                Math.min(10, QuestionRepository.getInstance().getAllQuestionsCount())
        );

        showQuestion();

        nextButton.setOnClickListener(v -> checkAnswerAndProceed());
    }

    private void showQuestion() {
        answersRadioGroup.removeAllViews();

        Question q = questions.get(currentIndex);
        questionTextView.setText(q.getText());

        if (q.getImageResId() != 0) {
            questionImageView.setImageResource(q.getImageResId());
        } else {
            questionImageView.setImageDrawable(null);
        }

        for (int i = 0; i < q.getAnswers().size(); i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(q.getAnswers().get(i));
            rb.setId(i);
            answersRadioGroup.addView(rb);
        }
    }

    private void checkAnswerAndProceed() {
        int selectedId = answersRadioGroup.getCheckedRadioButtonId();

        if (selectedId == questions.get(currentIndex).getCorrectIndex()) {
            score++;
        }

        currentIndex++;

        if (currentIndex < questions.size()) {
            showQuestion();
        } else {
            goToResult();
        }
    }

    private void goToResult() {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("score", score);
        intent.putExtra("total", questions.size());
        startActivity(intent);
        finish();
    }
}
