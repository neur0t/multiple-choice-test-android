package uniwa.university.quizapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import uniwa.university.quizapp.R;

public class ResultActivity extends AppCompatActivity {

    private TextView resultTextView;
    private Button finishButton;
    private Button retryButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultTextView = findViewById(R.id.resultTextView);
        finishButton = findViewById(R.id.finishButton);
        retryButton = findViewById(R.id.retryButton);

        int score = getIntent().getIntExtra("score", 0);
        int total = getIntent().getIntExtra("total", 0);
        int percentage = (total > 0)
                ? (int) ((score * 100.0f) / total)
                : 0;

        if (percentage >= 50) {
            resultTextView.setTextColor(
                    getResources().getColor(android.R.color.holo_green_dark)
            );
        } else {
            resultTextView.setTextColor(
                    getResources().getColor(android.R.color.holo_red_dark)
            );
        }


        SharedPreferences prefs =
                getSharedPreferences("quiz_prefs", MODE_PRIVATE);

        String studentName = prefs.getString("student_name", "Άγνωστος");

        String dateTime = new SimpleDateFormat(
                "dd/MM/yyyy HH:mm",
                Locale.getDefault()
        ).format(new Date());

        String resultText =
                "Εξεταζόμενος:\n" + studentName +
                        "\n\nΒαθμολογία:\n" + score + " / " + total +
                        "\n\nΠοσοστό Επιτυχίας:\n" + percentage + "%" +
                        "\n\nΗμερομηνία & Ώρα:\n" + dateTime;

        resultTextView.setText(resultText);

        saveResult(studentName, score, total, dateTime, percentage);

        finishButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();
        });

        retryButton.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void saveResult(String name, int score, int total, String dateTime, final int percentage) {
        SharedPreferences prefs =
                getSharedPreferences("quiz_results", MODE_PRIVATE);

        prefs.edit()
                .putString("last_name", name)
                .putInt("last_score", score)
                .putInt("last_total", total)
                .putString("last_time", dateTime)
                .putInt("last_percentage", percentage)
                .apply();
    }
}
