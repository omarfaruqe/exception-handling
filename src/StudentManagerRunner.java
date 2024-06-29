import java.util.Scanner;

public class StudentManagerRunner {
    public static void main(String[] args) {

        StudentManager manager = new StudentManager("res/students.csv");
        manager.readCSV();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter roll number to search:");
        int rollNumber = scanner.nextInt();
        Student student = manager.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student.name + ", " + student.rollNumber + ", " + student.marks);
        } else {
            System.out.println("Student not found");
        }

        System.out.println("Enter roll number to update:");
        rollNumber = scanner.nextInt();
        System.out.println("Enter new marks:");
        double newMarks = scanner.nextDouble();
        if (manager.updateStudent(rollNumber, newMarks)) {
            System.out.println("Student updated");
        } else {
            System.out.println("Student not found");
        }

        System.out.println("Enter roll number to delete:");
        rollNumber = scanner.nextInt();
        if (manager.deleteStudent(rollNumber)) {
            System.out.println("Student deleted");
        } else {
            System.out.println("Student not found");
        }
    }
}