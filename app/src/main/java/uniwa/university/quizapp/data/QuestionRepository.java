package uniwa.university.quizapp.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import uniwa.university.quizapp.R;

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

        List<String> a1 = new ArrayList<>();
        a1.add("Java");
        a1.add("HTML");
        a1.add("Python");
        a1.add("SQL");

        questions.add(new Question(
                "Ποια γλώσσα χρησιμοποιείται κυρίως για Android ανάπτυξη;",
                a1,
                0,
                R.drawable.ic_java
        ));

        List<String> a2 = new ArrayList<>();
        a2.add("Windows");
        a2.add("Linux");
        a2.add("macOS");

        questions.add(new Question(
                "Ποιο λειτουργικό σύστημα βασίζεται στον Linux kernel;",
                a2,
                1,
                R.drawable.ic_linux
        ));

        List<String> a3 = new ArrayList<>();
        a3.add("Λειτουργικό σύστημα");
        a3.add("Πλατφόρμα διαχείρισης κώδικα");
        a3.add("Γλώσσα προγραμματισμού");

        questions.add(new Question(
                "Τι είναι το GitHub;",
                a3,
                1,
                R.drawable.ic_github
        ));

        List<String> a4 = new ArrayList<>();
        a4.add("RAM");
        a4.add("CPU");
        a4.add("SSD");

        questions.add(new Question(
                "Ποια είναι η κύρια μονάδα επεξεργασίας ενός υπολογιστή;",
                a4,
                1,
                R.drawable.ic_cpu
        ));

        List<String> a5 = new ArrayList<>();
        a5.add("CPU");
        a5.add("RAM");
        a5.add("Hard Disk");

        questions.add(new Question(
                "Τι αποθηκεύει προσωρινά δεδομένα;",
                a5,
                1,
                R.drawable.ic_ram
        ));

        List<String> a6 = new ArrayList<>();
        a6.add("Android Studio");
        a6.add("Visual Studio");
        a6.add("Xcode");

        questions.add(new Question(
                "Ποια πλατφόρμα χρησιμοποιείται για Android εφαρμογές;",
                a6,
                0,
                R.drawable.ic_android
        ));

        List<String> a7 = new ArrayList<>();
        a7.add("HTTP");
        a7.add("FTP");
        a7.add("HTTPS");

        questions.add(new Question(
                "Ποιο πρωτόκολλο χρησιμοποιείται για ασφαλή μεταφορά δεδομένων;",
                a7,
                2,
                R.drawable.ic_security
        ));

        List<String> a8 = new ArrayList<>();
        a8.add("Λειτουργικό σύστημα");
        a8.add("Γλώσσα προγραμματισμού");
        a8.add("Βάση δεδομένων");

        questions.add(new Question(
                "Τι είναι το Python;",
                a8,
                1,
                R.drawable.ic_python
        ));

        List<String> a9 = new ArrayList<>();
        a9.add("Router");
        a9.add("Monitor");
        a9.add("Printer");

        questions.add(new Question(
                "Ποια συσκευή συνδέει υπολογιστές σε δίκτυο;",
                a9,
                0,
                R.drawable.ic_network
        ));

        List<String> a10 = new ArrayList<>();
        a10.add("Linux");
        a10.add("Android");
        a10.add("Windows");

        questions.add(new Question(
                "Ποιο λειτουργικό σύστημα ανέπτυξε η Microsoft;",
                a10,
                2,
                R.drawable.ic_windows
        ));
    }




    public List<Question> getRandomQuestions(int count) {
        Collections.shuffle(questions);
        return questions.subList(0, count);
    }

    public int getAllQuestionsCount() {
        return questions.size();
    }

}
