package model;

public class Teacher extends User {

    private int teacherId;
    private String subject;

    public Teacher(int teacherId, String username, String password,
                   String name, String subject) {

        super(username, password, name);

        this.teacherId = teacherId;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void displayDetails() {
        System.out.println("Teacher ID  : " + teacherId);
        System.out.println("Name        : " + name);
        System.out.println("Username    : " + username);
        System.out.println("Subject     : " + subject);
    }
}