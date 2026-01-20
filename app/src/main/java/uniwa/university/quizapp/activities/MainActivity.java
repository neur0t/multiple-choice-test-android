package uniwa.university.quizapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import uniwa.university.quizapp.R;
import uniwa.university.quizapp.model.Student;


public class MainActivity extends AppCompatActivity {

    private TextView studentsTextView;
    private Button continueButton;
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        studentsTextView = findViewById(R.id.studentsTextView);
        continueButton = findViewById(R.id.continueButton);

        loadStudents();
        displayStudents();

        continueButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, StudentInfoActivity.class);
            startActivity(intent);
        });
    }

    private void loadStudents() {
        students = new ArrayList<>();

        students.add(
                new Student(
                        "Παπαευθυμίου Εμμανουήλ",
                        "mscict24059"
                )
        );

        students.add(
                new Student(
                        "Γραμματικού Σωτηρία",
                        "mscict24015"
                )
        );

        students.add(
                new Student(
                        "Κακούρης Νικόλαος",
                        "mscict24029"
                )
        );

    }

    private void displayStudents() {
        StringBuilder builder = new StringBuilder();

        for (Student student : students) {
            builder.append(student.getFullName())
                    .append("\nΑΜ: ")
                    .append(student.getRegistrationNumber())
                    .append("\n\n");
        }

        studentsTextView.setText(builder.toString());

        SharedPreferences prefs =
                getSharedPreferences("quiz_results", MODE_PRIVATE);

        if (prefs.contains("last_name")) {
            String lastResult =
                    "\nΤελευταίο Αποτέλεσμα:\n" +
                            prefs.getString("last_name", "") + "\n" +
                            prefs.getInt("last_percentage", 0) + "%\n" +
                            prefs.getString("last_time", "");

            studentsTextView.append(lastResult);
        }
    }

}