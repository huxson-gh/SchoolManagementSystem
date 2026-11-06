package model;

public class Marks {

    private int studentId;
    private String subject;
    private double marks;
    private String grade;

    public Marks(int studentId, String subject, double marks) {

        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    private String calculateGrade(double marks) {

        if (marks >= 90) {
            return "A+";
        } else if (marks >= 80) {
            return "A";
        } else if (marks >= 70) {
            return "B";
        } else if (marks >= 60) {
            return "C";
        } else if (marks >= 50) {
            return "D";
        } else if (marks >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public double getMarks() {
        return marks;
    }

    public String getGrade() {
        return grade;
    }

    public void setMarks(double marks) {
        this.marks = marks;
        this.grade = calculateGrade(marks);
    }

    public void displayMarks() {
        System.out.println("Subject : " + subject);
        System.out.println("Marks   : " + marks);
        System.out.println("Grade   : " + grade);
    }
}