package ro.java.ctrln.lambda;

import ro.java.ctrln.lambda.model.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExpresions {
    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("John",23));
        students.add(new Student("Emily",26));
        students.add(new Student("Eliza",21));
        students.add(new Student("Ben",38));
        System.out.println("Ordine initiala !");
        System.out.println(students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student studentOne, Student studentTwo) {
                return Integer.compare(studentOne.getAge(),studentTwo.getAge());
            }
        });
        System.out.println("Ordine aranjata !");
        System.out.println(students);

        System.out.println("Ordine aleatoare cu shuffle !");
        Collections.shuffle(students);
        System.out.println(students);

        System.out.println("Ordine rearanjata cu student.sort !");
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student studentOne, Student studentTwo) {
                return Integer.compare(studentOne.getAge(),studentTwo.getAge());
            }
        });
        System.out.println("Rearanjarea dupa shuffle !");
        System.out.println(students);

        Collections.shuffle(students);
        System.out.println("Ordine aleatoare cu shuffle c expresie lambda !");
        System.out.println(students);
        System.out.println("Rearanjarea cu lambda !");
        students.sort((s1,s2)-> {
            return Integer.compare(s1.getAge(),s2.getAge());
                            //sau
        });
        System.out.println("O varianta mai prescurtata cu lambda !");
        students.sort((s1,s2) ->Integer.compare(s1.getAge(), s2.getAge()));
        System.out.println(students);
    }
}