package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {


    public static String optionalOrElse(){


        //Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        Optional<Student> studentOptional = Optional.ofNullable(null);

       String name =  studentOptional.map(Student::getName).orElse("Default");


       return  name;

    }

    //orElse
    //orElseget
    //orElseThrow

    public static void main(String[] args) {


        System.out.println(optionalOrElse());



    }
}
