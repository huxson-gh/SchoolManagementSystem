package controller;

import model.*;
import java.util.*;

public class StudentController {
    private final List<User> users; private final List<Attendance> attendanceList; private final List<Marks> marksList;
    public StudentController(List<User> users,List<Attendance> attendanceList,List<Marks> marksList){this.users=users;this.attendanceList=attendanceList;this.marksList=marksList;}
    public Student getStudent(int id){for(User u:users)if(u instanceof Student && ((Student)u).getStudentId()==id)return (Student)u;return null;}
    public Attendance getAttendance(int id){for(Attendance a:attendanceList)if(a.getStudentId()==id)return a;return null;}
    public List<Marks> getMarks(int id){List<Marks> out=new ArrayList<>();for(Marks m:marksList)if(m.getStudentId()==id)out.add(m);return out;}
}
