# School Management System (Java Swing)

A desktop-based School Management System developed in Java using the **MVC (Model-View-Controller)** architecture and **Java Swing** for its graphical user interface. Data is stored temporarily in `ArrayList` collections; no database is used.

## Features
- **Admin:** Add, view, edit and delete student, teacher and staff records.
- **Teacher:** View students, record attendance, enter marks and view student performance.
- **Student:** View personal details, attendance, marks and grades.
- **Staff:** View personal details.
- Separate graphical dashboards and logout/login flow for each role.

## Requirements
- JDK 8 or later
- Windows Command Prompt (or another terminal)

## Run using CMD
1. Extract the ZIP file.
2. Open the `SchoolManagementSystem` folder in File Explorer.
3. Type `cmd` in the address bar and press Enter.
4. Compile all source files:

```cmd
javac -d . Main.java model\*.java view\*.java controller\*.java
```

5. Run the application:

```cmd
java Main
```

## Default login credentials
| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin123` |
| Teacher | `teacher1` | `teacher123` |
| Student | `student1` | `student123` |
| Staff | `staff1` | `staff123` |

## Folder structure
```text
SchoolManagementSystem/
├── Main.java
├── README.md
├── model/       # Data/model classes
├── view/        # Swing windows and dashboards
└── controller/  # Login and role-specific application logic
```

## Notes
- This project does not use a database.
- Data is kept in memory and is reset when the application closes.
- Default credentials are for demonstration and testing only.
- Compiled `.class` files are not required in the submission; the `.java` source files are sufficient.
