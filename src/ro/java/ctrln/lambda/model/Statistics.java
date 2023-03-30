package ro.java.ctrln.lambda.model;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.Random;

public class Statistics {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John",23));
        students.add(new Student("Emily",25));
        students.add(new Student("Eliza",21));
        students.add(new Student("Ben",38));

        IntSummaryStatistics statistics = students.stream().mapToInt(student ->student.getAge()).summaryStatistics();
        System.out.println("Media virstelor: " + statistics.getAverage());
        System.out.println("Suma virstelor: " + statistics.getSum());
        System.out.println("Cea mai mica virsta: " + statistics.getMin());
        System.out.println("Numarul studentilor: " + statistics.getCount());

        Random random = new Random();
        random.ints().limit(10).forEach(number -> System.out.println(number));
        random.doubles().limit(10).forEach(number -> System.out.println(number));


    }
}
