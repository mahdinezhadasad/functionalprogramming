package Streams_terminal;

import data.Student;
import data.StudentDataBase;

import java.util.*;

import static java.util.stream.Collectors.*;

public class StreamGroupingByExample {

    public static void groupStudentByGender(){


      Map<String, List<Student>> studentMap= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGender));

        System.out.println(studentMap);

    }

    public static void cutomizedGroupingBy(){


        Map<String, List<Student>> studentMap= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" :"Average"));

        System.out.println(studentMap);

    }

    public static void twoLevelGrouping(){


        Map<Integer, Map<String,List<Student>>> studentMap= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,

                        groupingBy(student -> student.getGpa()>=3.8 ? "OUTSTANDING" :"Average")));

        System.out.println(studentMap);

    }

    public static void twoLeveelGrouping2(){


        Map<Integer, Integer> studentMap= StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,

                      summingInt(Student::getNoteBooks
                      )));

        System.out.println(studentMap);

    }
    public static void threeArgumentGroupby(){

       LinkedHashMap<String, Set<Student>> studentLinkedHashmaped =  StudentDataBase.getAllStudents()
                .stream()

                .collect(groupingBy(Student::getName, LinkedHashMap::new,toSet()));

        System.out.println(studentLinkedHashmaped);

    }

    public static void calculatetopGpa(){
        Map<Integer,Optional<Student>> studentOptional = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,
                        maxBy(Comparator.comparing(Student::getGpa))));


        System.out.println(studentOptional);

        Map<Integer, Student> studentMapOptional1 = StudentDataBase.getAllStudents()
                .stream()
                .collect(groupingBy(Student::getGradeLevel,

                        collectingAndThen(maxBy(Comparator.comparing(Student::getGpa))
                        , Optional::get


                        )
                ));


    }



    public static void main(String[] args) {

        //groupStudentByGender();
       // cutomizedGroupingBy();

       // twoLevelGrouping();

        //twoLeveelGrouping2();


        calculatetopGpa();
      //  threeArgumentGroupby();


    }
}
