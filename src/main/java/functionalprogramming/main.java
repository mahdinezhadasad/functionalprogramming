package functionalprogramming;

import data.Student;
import data.StudentDataBase;

import java.util.List;
import java.util.function.Consumer;

public class main {

    static Consumer<Student> c2 = (student)-> System.out.println(student);
    static Consumer<Student> c3 = (student -> System.out.println(student.getName()));
    static Consumer<Student> c4 = (student -> System.out.println(student.getActivities()));



    public static void printName(){

        List<Student> studentDataBase = data.StudentDataBase.getAllStudents();

        studentDataBase.forEach(c2);

    }

    public static void printNameAndActivitiesUsingCondition(){

        List<Student> studentList = StudentDataBase.getAllStudents();


        studentList.forEach((student -> {if(student.getGradeLevel()>=3 && student.getGpa() > 3){

                  c3.andThen(c4).accept(student);

        }

        }));

    }

    public static void main(String[] args) {
        printNameAndActivitiesUsingCondition();

    }
}
