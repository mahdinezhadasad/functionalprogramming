package functionalprogramming;

import data.Student;
import data.StudentDataBase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class FunctionStudentExample {


    static Function<List<Student>, Map<String, Double >> stundentFunction = (students -> {

        Map<String,Double> studentGrademap = new HashMap<>();

        students.forEach(student -> {

            if(PredicateStudentExample.p1.test(student)){
           studentGrademap.put(student.getName(),student.getGpa());
            }

        });

        return studentGrademap;

    });

    public static void main(String[] args) {

        System.out.println(stundentFunction.apply(StudentDataBase.getAllStudents()));

    }
}
