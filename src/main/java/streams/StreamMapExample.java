package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMapExample {


    public static List<String> namesList(){


        List<String> studentList = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)

                .collect(Collectors.toList());


           return  studentList;

    }

    public static Set<String> namesList1(){


        Set<String> studentList = StudentDataBase.getAllStudents().stream()
                .map(Student::getName)
                .map(String::toUpperCase)

                .collect(Collectors.toSet());


        return  studentList;

    }

    public static void main(String[] args) {

        System.out.println(namesList());

        System.out.println(namesList1());




    }
}
