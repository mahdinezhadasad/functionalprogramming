package streams;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {

    public static List<String> printStudentActivities(){


        List<String> studentActivities = StudentDataBase.getAllStudents()
                .stream()
                .map(Student::getActivities)// Stream<List<String>
                .flatMap(List::stream)// Stream<String>
                .distinct()
                .sorted()
                .collect(Collectors.toList());

        return  studentActivities;
    }

    public static long getStudentActivitiesCount(){


        long noOfStudentActivities = StudentDataBase.getAllStudents().stream()
                .map(Student::getActivities)
                .flatMap(List::stream)
                .distinct()

                .count();

        return noOfStudentActivities;
    }


    public static void main(String[] args) {


        System.out.println("printStudentActivities " + printStudentActivities());

        System.out.println("Total number of acttivities " + getStudentActivitiesCount());



    }
}
