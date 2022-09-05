import java.util.ArrayList;

public class Admin {
    private int id = 0;
    private String name;
    private String email;
    private int mobileNumber;

    public static int count = 0;

    private ArrayList<Teacher> teachers;
    private ArrayList<Student> students;

    public Admin() {
        this("Unknown","Unknown",0);
    }

    public Admin(String name, String email, int mobileNumber) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.id = count;
        count++;
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

    public int getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(int mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

}
