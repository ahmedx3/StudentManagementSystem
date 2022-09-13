import java.util.Map;

public class Admin extends Person {
    private final int id;

    private static int count = 0;

    /////////// Constructors ///////////

    public Admin() {
        super();
        this.id = count;
        count++;
    }

    public Admin(String name, String email, String mobileNumber) {
        super(name,email,mobileNumber);
        this.id = count;
        count++;
    }

    /////////// Functions ///////////

    void addTeacher(Teacher t) {
        Database.getInstance().getTeachers().put(t.getId(),t);
        System.out.println("Teacher added successfully!\n");
    }

    void removeTeacher(Teacher t) {
        Database.getInstance().getTeachers().remove(t.getId());
        System.out.println("Teacher removed successfully!\n");
    }

    void viewAllTeachers() {
        for (Map.Entry<Integer,Teacher> entry : Database.getInstance().getTeachers().entrySet()) {
            System.out.println(entry.getValue());
        }
        Teacher.isPrinted = false;
    }

    void viewTeacherDetails(Teacher t) {
        System.out.println(t);
        Teacher.isPrinted = false;
    }

    void updateTeacherData(Teacher t,String name,String email,String mobileNumber) {
        if (Database.getInstance().getTeachers().containsKey(t.getId())) {
            Teacher teacher = Database.getInstance().getTeachers().get(t.getId());
            teacher.setName(name);
            teacher.setEmail(email);
            teacher.setMobileNumber(mobileNumber);
            Database.getInstance().getTeachers().put(t.getId(), teacher);
        } else {
            System.out.println("Teacher not found!");
        }
    }

    void addStudent(Student s) {
        // TODO: make exception if already found (custom exception)
        Database.getInstance().getStudents().put(s.getId(),s);
        System.out.println("Student Added Successfully!");
    }

    void removeStudent(Student s) {
        Database.getInstance().getStudents().remove(s.getId());
    }

    void viewAllStudents() {
        for (Map.Entry<Integer,Student> entry : Database.getInstance().getStudents().entrySet()) {
            System.out.println(entry.getValue());
        }
        Student.isPrinted = false;
    }

    void viewStudentDetails(Student s) {
        System.out.println(s);
        Student.isPrinted = false;
    }

    void updateStudentData(Student s,String name,String email,String mobileNumber) {
        if (Database.getInstance().getStudents().containsKey(s.getId())) {
            Student student = Database.getInstance().getStudents().get(s.getId());
            student.setName(name);
            student.setEmail(email);
            student.setMobileNumber(mobileNumber);
            Database.getInstance().getStudents().put(s.getId(), student);
        } else {
            System.out.println("Student not found!");
        }
    }

    void addCourse(Course c) {
        Database.getInstance().getCourses().put(c.getId(),c);
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
