package ro.java.ctrln.method.referecences;

import ro.java.ctrln.lambda.model.Student;

public class BittnetConstructorReference {
    public static void main(String[] args) {
        StudentFactory studentFactory = Student::new; // Prin :: referim constructorul "Student" din classa Student
        Student student = studentFactory.getStudent("John",23);
        System.out.println(student);
    }
}
