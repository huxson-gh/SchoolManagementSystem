package controller;

import model.*;
import java.util.*;

public class AdminController {
    private final List<User> users;
    public AdminController(List<User> users) { this.users = users; }

    public List<Student> getStudents() { List<Student> out=new ArrayList<>(); for(User u:users) if(u instanceof Student) out.add((Student)u); return out; }
    public List<Teacher> getTeachers() { List<Teacher> out=new ArrayList<>(); for(User u:users) if(u instanceof Teacher) out.add((Teacher)u); return out; }
    public List<Staff> getStaff() { List<Staff> out=new ArrayList<>(); for(User u:users) if(u instanceof Staff) out.add((Staff)u); return out; }
    public boolean addStudent(Student s) { if(usernameExists(s.getUsername()) || studentIdExists(s.getStudentId())) return false; users.add(s); return true; }
    public boolean deleteStudent(int id) { return users.removeIf(u -> u instanceof Student && ((Student)u).getStudentId()==id); }
    public boolean modifyStudent(int id,String name,String password,String className) { for(Student s:getStudents()) if(s.getStudentId()==id){s.setName(name);s.setPassword(password);s.setClassName(className);return true;} return false; }
    public boolean addTeacher(Teacher t) { if(usernameExists(t.getUsername()) || teacherIdExists(t.getTeacherId())) return false; users.add(t); return true; }
    public boolean deleteTeacher(int id) { return users.removeIf(u -> u instanceof Teacher && ((Teacher)u).getTeacherId()==id); }
    public boolean modifyTeacher(int id,String name,String password,String subject) { for(Teacher t:getTeachers()) if(t.getTeacherId()==id){t.setName(name);t.setPassword(password);t.setSubject(subject);return true;} return false; }
    public boolean addStaff(Staff s) { if(usernameExists(s.getUsername()) || staffIdExists(s.getStaffId())) return false; users.add(s); return true; }
    public boolean deleteStaff(int id) { return users.removeIf(u -> u instanceof Staff && ((Staff)u).getStaffId()==id); }
    public boolean modifyStaff(int id,String name,String password,String department) { for(Staff s:getStaff()) if(s.getStaffId()==id){s.setName(name);s.setPassword(password);s.setDepartment(department);return true;} return false; }
    private boolean usernameExists(String name) { for(User u:users) if(u.getUsername().equalsIgnoreCase(name)) return true; return false; }
    private boolean studentIdExists(int id) { for(Student s:getStudents()) if(s.getStudentId()==id) return true; return false; }
    private boolean teacherIdExists(int id) { for(Teacher t:getTeachers()) if(t.getTeacherId()==id) return true; return false; }
    private boolean staffIdExists(int id) { for(Staff s:getStaff()) if(s.getStaffId()==id) return true; return false; }
}
