package model;

public class Staff extends User {

    private int staffId;
    private String department;

    public Staff(int staffId, String username, String password,
                 String name, String department) {

        super(username, password, name);

        this.staffId = staffId;
        this.department = department;
    }

    public int getStaffId() {
        return staffId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void displayDetails() {
        System.out.println("Staff ID    : " + staffId);
        System.out.println("Name        : " + name);
        System.out.println("Username    : " + username);
        System.out.println("Department  : " + department);
    }
}