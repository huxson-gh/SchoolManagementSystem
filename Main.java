import model.*;
import view.*;
import controller.*;
import javax.swing.*;
import java.util.*;

public class Main {
 public static void main(String[] args){SwingUtilities.invokeLater(Main::startApplication);}
 private static void startApplication(){
  List<User> users=new ArrayList<>(); List<Attendance> attendanceList=new ArrayList<>(); List<Marks> marksList=new ArrayList<>();
  users.add(new Admin(1,"admin","admin123","System Administrator"));
  users.add(new Teacher(101,"teacher1","teacher123","Arijit Ghosal","OOPS"));
  users.add(new Student(1001,"student1","student123","Agniva Bhattacharyya","IT - 3rd Year"));
  users.add(new Staff(201,"staff1","staff123","Suresh Das","Administration"));
  LoginController loginController=new LoginController(users); AdminController adminController=new AdminController(users);
  TeacherController teacherController=new TeacherController(users,attendanceList,marksList);
  StudentController studentController=new StudentController(users,attendanceList,marksList); StaffController staffController=new StaffController(users);
  showLogin(loginController,adminController,teacherController,studentController,staffController);
 }
 private static void showLogin(LoginController login,AdminController admin,TeacherController teacher,StudentController student,StaffController staff){
  LoginView view=new LoginView((username,password)->{User u=login.login(username,password);if(u==null){viewHolder[0].showError("Invalid username or password. Please try again.");return;}viewHolder[0].dispose();Runnable back=()->showLogin(login,admin,teacher,student,staff);
   if(u instanceof Admin)new AdminView(admin,u.getName(),back);
   else if(u instanceof Teacher)new TeacherView(teacher,u.getName(),back);
   else if(u instanceof Student)new StudentView(student,(Student)u,back);
   else if(u instanceof Staff)new StaffView(staff,(Staff)u,back);
  });viewHolder[0]=view;view.setVisible(true);
 }
 private static final LoginView[] viewHolder=new LoginView[1];
}
