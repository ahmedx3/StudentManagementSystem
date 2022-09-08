

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
        Database.getInstance().getTeachers().add(t);
        System.out.println("Teacher added successfully!\n");
    }

    void removeTeacher(Teacher t) {
        Database.getInstance().getTeachers().remove(t);
        System.out.println("Teacher removed successfully!\n");
    }

    void viewAllTeachers() {
        for(Teacher t: Database.getInstance().getTeachers()){
            System.out.println(t);
        }
    }

    void viewTeacherDetails(Teacher t) {
        System.out.println(t);
    }

    void updateTeacherData(Teacher t,String name,String email,String mobileNumber) {
        boolean found = false;
        for (Teacher teacher: Database.getInstance().getTeachers()) {
            if (teacher.equals(t)) {
                teacher.setName(name);
                teacher.setEmail(email);
                teacher.setMobileNumber(mobileNumber);
                found = true;
                System.out.println("Teacher updated successfully!");
            }
        }
        if (!found) {
            System.out.println("Teacher not found!");
        }
    }

    void addStudent(Student s) {
        Database.getInstance().getStudents().add(s);
        System.out.println("Student Added Successfully!");
    }

    void removeStudent(Student s) {
        Database.getInstance().getStudents().remove(s);
    }

    void viewAllStudents() {
        for(Student s: Database.getInstance().getStudents()){
            System.out.println(s);
        }
    }

    void viewStudentDetails(Student s) {
        System.out.println(s);
    }

    void updateStudentData(Student s,String name,String email,String mobileNumber) {
        for (Student student: Database.getInstance().getStudents()) {
            if (student.equals(s)) {
                student.setName(name);
                student.setEmail(email);
                student.setMobileNumber(mobileNumber);
            }
            else {
                System.out.println("Student not found!");
            }
        }
    }

    void addCourse(Course c) {
        Database.getInstance().getCourses().add(c);
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
