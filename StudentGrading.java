import java.util.Scanner;

class Student{
    String name;
    int id;
    double subject1;
    double subject2;
    double subject3;
    double subject4;
    double subject5;
    double average;
    double totalMarks;
    char  grade;

    Student(String name, int id, double subject1, double subject2, double subject3, double subject4, double subject5) {
        this.name = name;
        this.id = id;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        totalMarks = subject1 + subject2 + subject3 + subject4 + subject5;
        average = totalMarks/5;
    }

    void display() {
        System.out.printf("%-5d  %-18s  %12.2f  %17f  %5c\n", id, name, totalMarks, average, grade);
    }
}

class Classroom {
    Student students[];
    int index = 0;

    Classroom(int size) {
        students = new Student[size];
    }

    void addStudent(Student student) {
        students[index] = student;
        index++;
    }

    void findGrade() {
        for (int i = 0; i < index; i++) {
            if (students[i].average >= 90) {
                students[i].grade = 'A';
            } else if (students[i].average >= 75) {
                students[i].grade = 'B';
            } else if (students[i].average >= 60) {
                students[i].grade = 'C';
            } else if (students[i].average >= 50) {
                students[i].grade = 'D';
            } else {
                students[i].grade = 'F';
            }
        }
    }

    void displayAllStudents() {
        System.out.println();
        System.out.print("ID            Name               Total Marks     Average      Grade\n");
        System.out.println("----------------------------------------------------------------------");
        for(int i = 0; i < index; i++) {
            students[i].display();
        }
    }
}    

public class StudentGrading {
    public static void main(String[] args) {
        Scanner accept = new Scanner(System.in);
        System.out.print("Input number of students: ");
        int n = accept.nextInt();
        System.out.println();
        Classroom classroom = new Classroom(n);
        for(int i = 1; i <= n; i++) {
            System.out.println();
            System.out.println("Student " + i + ":");
            System.out.print("Name: ");
            String name = accept.next();
            System.out.print("ID: ");
            int id = accept.nextInt();
            System.out.print("Subject 1 marks: ");
            double subject1 = accept.nextDouble();
            System.out.print("Subject 2 marks: ");
            double subject2 = accept.nextDouble();
            System.out.print("Subject 3 marks: ");
            double subject3 = accept.nextDouble();
            System.out.print("Subject 4 marks: ");
            double subject4 = accept.nextDouble();
            System.out.print("Subject 5 marks: ");
            double subject5 = accept.nextDouble();
            classroom.addStudent(new Student(name, id, subject1, subject2, subject3, subject4, subject5));
        }
        accept.close();
        classroom.findGrade();
        classroom.displayAllStudents();
    }
}