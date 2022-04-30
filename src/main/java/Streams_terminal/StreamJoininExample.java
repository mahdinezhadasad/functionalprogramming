package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

public class StreamJoininExample {

    public static String joining_1(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining());


    }

    public static String joining_2(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-"));


    }

    public static String joining_3(){
        return StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getName)
                .collect(Collectors.joining("-","(",")"));


    }
    public static void main(String[] args) {


        System.out.println("joining method" + joining_1());
        System.out.println("joining method" + joining_2());
        System.out.println("joining method" + joining_3());



    }
}
