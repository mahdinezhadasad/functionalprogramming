package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMinByMaxByExample {

    public static Optional<Student> minBy(){


       return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));
    }

    public static Optional<Student> maxBy_example(){
        return  StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));


    }

    public static void main(String[] args) {

        System.out.println(minBy());
        System.out.println(maxBy_example());


    }
}
