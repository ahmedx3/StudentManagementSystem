import java.util.ArrayList;
import java.util.List;

public class Admin {
    private final int id;
    private String name;
    private String email;
    private String mobileNumber;

    private static int count = 0;

    /////////// Constructors ///////////

    public Admin() {
        this("Undefined","Undefined","0");
    }

    public Admin(String name, String email, String mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    void addTeacher(Teacher t) {
        Database.teachers.add(t);
    }

    void removeTeacher(Teacher t) {
        Database.teachers.remove(t);
    }

    void viewAllTeachers() {
        for(Teacher t: Database.teachers){
            System.out.println("Teacher Name: " + t.getName());
        }
    }

    void viewTeacherDetails(Teacher t) {
        System.out.println("Teacher Name: " + t.getName());
        System.out.println("Teacher Email: " + t.getEmail());
    }

    void updateTeacherData(Teacher t,String name,String email,String mobileNumber) {
        for (Teacher teacher: Database.teachers) {
            if (teacher.equals(t)) {
                teacher.setName(name);
                teacher.setEmail(email);
                teacher.setMobileNumber(mobileNumber);
            }
        }
    }

    void addStudent(Student s) {
        Database.students.add(s);
    }

    void removeStudent(Student s) {
        Database.students.remove(s);
    }

    void viewAllStudents() {
        for(Student s: Database.students){
            System.out.println("Student Name: " + s.getName());
        }
    }

    void viewStudentDetails(Student s) {
        System.out.println("Student Name: " + s.getName());
        System.out.println("Student Email: " + s.getEmail());
    }

    void updateStudentData(Student s,String name,String email,String mobileNumber) {
        for (Student student: Database.students) {
            if (student.equals(s)) {
                student.setName(name);
                student.setEmail(email);
                student.setMobileNumber(mobileNumber);
            }
        }
    }

    void addCourse(Course c) {
        Database.courses.add(c);
    }

    /////////// Setters and Getters ///////////

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

}
