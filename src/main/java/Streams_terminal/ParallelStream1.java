package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class ParallelStream1 {

    public static List<String> sequetialPrinStudentActivities(){

        long startTime = System.currentTimeMillis();

        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .parallel()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        long endTime= System.currentTimeMillis();

        System.out.println("sequetffialtime : " + ( endTime-startTime));

        return studentActivities;


    }

    public static List<String> parallelPrintStudentActivities(){

        long startTime = System.currentTimeMillis();

        List<String>  studentActivites = StudentDataBase.getAllStudents()
                .parallelStream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());


        long endTime= System.currentTimeMillis();

        System.out.println("parallelTime : " + ( endTime-startTime));

        return studentActivites;



    }

    public static void main(String[] args) {
        sequetialPrinStudentActivities();
        parallelPrintStudentActivities();




    }
}
