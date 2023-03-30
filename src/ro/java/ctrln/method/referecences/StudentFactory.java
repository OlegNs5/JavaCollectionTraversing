package ro.java.ctrln.method.referecences;

import ro.java.ctrln.lambda.model.Student;

@FunctionalInterface
public interface StudentFactory {
        Student getStudent(String name, int age);
        // Student getStudent(String name); //Trebuie sa avem o singura metoda abstracta in contractul interfetei
        //atunci adnotam interfata cu @FunctionalInterface

}
