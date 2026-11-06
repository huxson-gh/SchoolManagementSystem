package controller;
import model.*; import java.util.*;
public class StaffController { private final List<User> users; public StaffController(List<User> users){this.users=users;} public Staff getStaff(int id){for(User u:users)if(u instanceof Staff && ((Staff)u).getStaffId()==id)return (Staff)u;return null;} }
