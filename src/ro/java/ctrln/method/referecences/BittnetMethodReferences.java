package ro.java.ctrln.method.referecences;

import ro.java.ctrln.lambda.model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class BittnetMethodReferences {
    public static void main(String[] args) {
        //Referirea unei metode statice
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        integers.forEach(BittnetMethodReferences::print);
        System.out.println();
        //Expresie lambda
        integers.forEach(integer -> BittnetMethodReferences.print(integer));
        System.out.println();
        System.out.println();

        BittnetComparator bittnetComparator = new BittnetComparator();
        //Referinta metoda dintr-un obiect particular
        Collections.sort(integers, bittnetComparator::compare);
        System.out.println(integers);
        //Expresie lambda
        Collections.sort(integers, (a, b) -> bittnetComparator.compare(a, b));
        System.out.println(integers);
        System.out.println();

        //Referinta pe o metada a unui obiect de un anume tip
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John", 23));
        students.add(new Student("Emily", 25));
        students.add(new Student("Eliza", 21));
        students.add(new Student("Ben", 38));

        students.sort(Comparator.comparing(Student::getAge));
        System.out.println("Studentii sortati: ");
        System.out.println(students);

        //Referinta metodei
        students.forEach(Student::printSomething);
        System.out.println();
        //Expresie lambda
        students.forEach(Student -> Student.printSomething());


    }
    public static void print (Integer integer)
    {
        System.out.print(integer + " ");
    }
    private static class BittnetComparator{
        public int compare ( Integer a, Integer b){
            return a.compareTo(b);
        }
    }
}
