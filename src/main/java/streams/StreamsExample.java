package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsExample {

    public static void main(String[] args) {


        Predicate<Student> studentPredicate = (student -> student.getGradeLevel()>=3);
        Predicate<Student>  studentPredicate1 = (student -> student.getGpa() >=3.9);

//        Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
//
//                .filter((student -> student.getGradeLevel()>=3))
//                .collect(Collectors.toMap(Student::getName,Student::getActivities));
//
//
        Map<String, List<String>> studentMap1 = StudentDataBase.getAllStudents().stream()

                .filter(studentPredicate)
                .filter(studentPredicate1)
                .collect(Collectors.toMap(Student::getName,Student::getActivities));

        System.out.println(studentMap1);


    }
}
