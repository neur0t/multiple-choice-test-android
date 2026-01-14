package uniwa.university.quizapp.model;

public class Student {

    private String fullName;
    private String registrationNumber;

    public Student(String fullName, String registrationNumber) {
        this.fullName = fullName;
        this.registrationNumber = registrationNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
