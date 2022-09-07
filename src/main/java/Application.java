import java.util.Date;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Admin admin = new Admin();

        Teacher teacher1 = new Teacher("Ahmed","ahmed@gmail.com","01009651241");
        Teacher teacher2 = new Teacher("Mohamed","mohamed@gmail.com","01004351342");
        Teacher teacher3 = new Teacher("Ali","ali@gmail.com","01234346846");
        Student student1 = new Student("Abdallah","abdallah@gmail.com","01007896541",24,"address1",Gender.MALE);
        Student student2 = new Student("Islam","islam@gmail.com","01107896541",23,"address2",Gender.MALE);
        Course course1 = new Course("CMPN211",teacher1);
        Course course2 = new Course("CMPN480",teacher2);
        Assignment assignment1 = new Assignment("Do 1",0 , new Date());
        AssignmentSubmission assignmentSubmission1 = new AssignmentSubmission(assignment1.getId(),student1.getId(),course1.getId(),new Date(),"Submittion 1",98);

        admin.addTeacher(teacher1);
        admin.addTeacher(teacher2);
        admin.addTeacher(teacher3);
        admin.addStudent(student1);
        admin.addStudent(student2);
        admin.addCourse(course1);

        admin.updateTeacherData(teacher1,"Hassan","hassan@gmail.com","01565646846");
        admin.updateTeacherData(teacher1,"Rafaat","rafaat@gmail.com","0156232846");
        admin.removeTeacher(teacher1);
        admin.viewAllTeachers();

        student1.enrollInCourse(course1);
        student1.enrollInCourse(course2);
        student1.viewEnrolledCourses();

        student2.enrollInCourse(course1);

        List<Student> enrolledStudents = teacher1.getStudentsInCourse(Database.getInstance().getCourses().get(0).getId());
        for (Student s: enrolledStudents) {
            System.out.println(s);
        }

        teacher3.getStudentData(student2.getId());

        teacher1.addAssignment(assignment1);

        student1.viewAssignments(0);

        teacher1.viewStudentAssignedCourses();

        student1.submitAssignment(assignmentSubmission1);
    }
}
