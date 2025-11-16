import java.util.*;

public class StudentTest {
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student("HEN Chhorda Vattey", 20230043, "SE");

        student1.setUpdateName("PI Sereyvathanak");
        student1.setUpdateID(20240045);
        student1.setUpdateMajor("SE");

        List<Student> students = new ArrayList<Student>();
        students.add(student1);
        students.add(student2);
        students.add(new Student("EANG Mengly", 20240009, "SE"));
        students.add(new Student("PAV Ratana", 20240047, "SE"));
        students.add(new Student("KONG Sophanha", 20240063, "SE"));

        for (Student s : students) {
            s.print();
            System.out.println("-----");
        }

        
    }
}