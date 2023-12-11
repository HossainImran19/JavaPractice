package advance.java.imran.BDefinitionSyntax.f.function.packg;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FuntionDemo {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("imran", 30, Student.Gender.MALE),
                new Student("Ayat", 18, Student.Gender.FEMALE),
                new Student("abid", 12, Student.Gender.MALE),
                new Student("afzal", 53, Student.Gender.MALE),
                new Student("mizan", 60, Student.Gender.MALE)
        );

        Function<Student, String> nameFunc = s -> s.getName();

        Function<Student, String> genderFunc = s -> s.getGender().toString();

        Function<Student, String> ageFunc = s -> String.valueOf(s.getAge());

        StudentProcessor studentProcessor = new StudentProcessor();

        List<String> names = studentProcessor.process(students, nameFunc);
        List<String> ages = studentProcessor.process(students, ageFunc);
        List<String> genders = studentProcessor.process(students, genderFunc);

        Predicate<Student> olderThan50 = s -> s.getAge() > 50;
        Predicate<Student> femaleOnly = s -> s.getGender().equals(Student.Gender.FEMALE);


        List<Student> studentOlderThan50 = studentProcessor.filter(students, olderThan50);
        List<Student> femaleStudents = studentProcessor.filter(students, femaleOnly);

        System.out.println("============================================");
        for (Student student : studentOlderThan50) {
            System.out.println(student);
        }

        System.out.println("\n==========================================");
        for (Student student : femaleStudents) {
            System.out.println(student);
        }
    }
}
