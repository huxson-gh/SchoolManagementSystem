package model;

public class Attendance {

    private int studentId;
    private int totalClasses;
    private int attendedClasses;

    public Attendance(int studentId) {
        this.studentId = studentId;
        this.totalClasses = 0;
        this.attendedClasses = 0;
    }

    public int getStudentId() {
        return studentId;
    }

    public int getTotalClasses() {
        return totalClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public void addAttendance(boolean present) {

        totalClasses++;

        if (present) {
            attendedClasses++;
        }
    }

    public double getAttendancePercentage() {

        if (totalClasses == 0) {
            return 0.0;
        }

        return (attendedClasses * 100.0) / totalClasses;
    }
}