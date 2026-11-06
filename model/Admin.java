package model;

public class Admin extends User {

    private int adminId;

    public Admin(int adminId, String username, String password, String name) {
        super(username, password, name);
        this.adminId = adminId;
    }

    public int getAdminId() {
        return adminId;
    }

    public void displayDetails() {
        System.out.println("Admin ID    : " + adminId);
        System.out.println("Name        : " + name);
        System.out.println("Username    : " + username);
    }
}