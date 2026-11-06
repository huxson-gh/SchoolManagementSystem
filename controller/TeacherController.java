package controller;

import model.*;
import java.util.*;

public class TeacherController {
    private final List<User> users; private final List<Attendance> attendanceList; private final List<Marks> marksList;
    public TeacherController(List<User> users,List<Attendance> attendanceList,List<Marks> marksList){this.users=users;this.attendanceList=attendanceList;this.marksList=marksList;}
    public List<Student> getStudents(){List<Student> out=new ArrayList<>();for(User u:users)if(u instanceof Student)out.add((Student)u);return out;}
    public List<Attendance> getAttendanceRecords(){return new ArrayList<>(attendanceList);}
    public List<Marks> getMarksForStudent(int id){List<Marks> out=new ArrayList<>();for(Marks m:marksList)if(m.getStudentId()==id)out.add(m);return out;}
    public boolean markAttendance(int id,boolean present){Student s=findStudent(id);if(s==null)return false;Attendance a=findAttendance(id);if(a==null){a=new Attendance(id);attendanceList.add(a);}a.addAttendance(present);s.setAttendance(a.getAttendancePercentage());return true;}
    public boolean enterMarks(int id,String subject,double marks){if(findStudent(id)==null || subject==null || subject.trim().isEmpty() || marks<0 || marks>100)return false;marksList.add(new Marks(id,subject.trim(),marks));return true;}
    public Student findStudent(int id){for(Student s:getStudents())if(s.getStudentId()==id)return s;return null;}
    private Attendance findAttendance(int id){for(Attendance a:attendanceList)if(a.getStudentId()==id)return a;return null;}
}
