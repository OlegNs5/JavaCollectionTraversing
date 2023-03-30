package ro.java.ctrln.lambda;

import ro.java.ctrln.lambda.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BittnetReduction {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John",23));
        students.add(new Student("Emily",25));
        students.add(new Student("Eliza",21));
        students.add(new Student("Ben",38));

        //Media virstelor studentilor
        double average = students.stream()
                .filter(student -> student.getAge() < 50)
                .mapToInt(student -> student.getAge())
                .average()
                .getAsDouble();
        System.out.println("Media virstelor este: " + average+";");

        // Suma virstelor studentilor
        int sumOfAges = students.stream()
                .mapToInt(student -> student.getAge())
                .sum();
        System.out.println("Suma virstelor studentilor este: " + sumOfAges);

        int sumOfAgesReduce = students.stream().map(student -> student.getAge()).reduce(0,(a,b) -> a+b);
        System.out.println("Suma virstelor studentilor cu reduce este: " + sumOfAgesReduce);

        List<String> studentsNames = students.stream()
                .filter(student -> student.getAge() < 30 )
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(studentsNames);
    }
}
