package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamMappingExample {

    public static void main(String[] args) {

       List<String> nameList = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName, toList()));

        System.out.println("nameList : " + nameList);

        Set<String> nameSet  = StudentDataBase.getAllStudents()
                .stream()
                .collect(mapping(Student::getName,toSet()));

        System.out.println("namesSet : " + nameSet);
    }
}
