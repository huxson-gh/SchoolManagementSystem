package model;

public class Student extends User {

    private int studentId;
    private String className;
    private double attendance;

    public Student(int studentId, String username, String password,
                   String name, String className) {

        super(username, password, name);

        this.studentId = studentId;
        this.className = className;
        this.attendance = 0.0;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getClassName() {
        return className;
    }

    public double getAttendance() {
        return attendance;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setAttendance(double attendance) {
        this.attendance = attendance;
    }

    public void displayDetails() {
        System.out.println("Student ID  : " + studentId);
        System.out.println("Name        : " + name);
        System.out.println("Username    : " + username);
        System.out.println("Class       : " + className);
        System.out.printf("Attendance  : %.2f%%%n", attendance);
    }
}