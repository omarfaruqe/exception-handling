import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManager{
    List<Student> students = new ArrayList<>();
    String fileName;

public StudentManager(String fileName) {
    this.fileName = fileName;
}

public void readCSV() {
    String line;
    String cvsSplitBy = ",";

    try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
        while ((line = br.readLine()) != null) {
            String[] studentInfo = line.split(cvsSplitBy);
            String name = studentInfo[0];
            int rollNumber = Integer.parseInt(studentInfo[1]);
            double marks = Double.parseDouble(studentInfo[2]);

            Student student = new Student(name, rollNumber, marks);
            students.add(student);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public Student searchStudent(int rollNumber) {
    for (Student student : students) {
        if (student.rollNumber == rollNumber) {
            return student;
        }
    }
    return null;
}

public boolean updateStudent(int rollNumber, double newMarks) {
    for (Student student : students) {
        if (student.rollNumber == rollNumber) {
            student.marks = newMarks;
            writeCSV();
            return true;
        }
    }
    return false;
}

public boolean deleteStudent(int rollNumber) {
    for (int i = 0; i < students.size(); i++) {
        if (students.get(i).rollNumber == rollNumber) {
            students.remove(i);
            writeCSV();
            return true;
        }
    }
    return false;
}

public void writeCSV() {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
        for (Student student : students) {
            bw.write(student.name + "," + student.rollNumber + "," + student.marks);
            bw.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}