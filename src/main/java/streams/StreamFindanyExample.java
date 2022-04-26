package streams;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class StreamFindanyExample {

    public static Optional<Student> findanyStudent(){

        return  StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.5)
                .findAny();


    }

    public static Optional<Student> findFirstStudent(){

        return  StudentDataBase.getAllStudents().stream()
                .filter(student -> student.getGpa()>=3.7)
                .findFirst();


    }


    public static void main(String[] args) {

        Optional<Student> studentOptionalfindAny = findanyStudent();


        if(studentOptionalfindAny.isPresent()){


            System.out.println("Found the student : "+ studentOptionalfindAny.get());
        }

        Optional<Student> studentOptionalfindFirst = findanyStudent();


        if(findFirstStudent().isPresent()){


            System.out.println("Found the student : "+ findFirstStudent().get());
        }



    }
}
