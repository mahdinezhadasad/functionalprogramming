package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.stream.Collectors;

import static java.util.stream.Collectors.averagingInt;

public class StreamSumAvgExample {

    public static int Sum(){


        return StudentDataBase.getAllStudents()
                .stream()
                .collect(Collectors.summingInt(Student::getNoteBooks));
    }

    public static double average(){


        return StudentDataBase.getAllStudents()
                .stream()
                .collect(averagingInt(Student :: getNoteBooks));
    }

    public static void main(String[] args) {

        System.out.println("average of  note books " +average());
        System.out.println("sum of  note books " + Sum());



    }
}
