package uniwa.university.quizapp.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import uniwa.university.quizapp.R;

public class StudentInfoActivity extends AppCompatActivity {

    private EditText nameEditText;
    private Button startQuizButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_info);

        nameEditText = findViewById(R.id.nameEditText);
        startQuizButton = findViewById(R.id.startQuizButton);

        startQuizButton.setOnClickListener(v -> {
            String name = nameEditText.getText().toString().trim();

            if (name.isEmpty()) {
                Toast.makeText(this, "Παρακαλώ εισάγετε όνομα", Toast.LENGTH_SHORT).show();
                return;
            }

            saveStudentName(name);

            Intent intent = new Intent(
                    StudentInfoActivity.this,
                    QuizActivity.class
            );
            startActivity(intent);
        });
    }

    private void saveStudentName(String name) {
        SharedPreferences prefs =
                getSharedPreferences("quiz_prefs", MODE_PRIVATE);

        prefs.edit()
                .putString("student_name", name)
                .apply();
    }
}
