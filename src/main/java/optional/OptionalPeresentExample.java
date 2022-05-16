package optional;

import data.Bike;
import data.Student;
import data.StudentDataBase;

import java.sql.SQLOutput;
import java.util.Optional;

public class OptionalPeresentExample {

    public static void optionalMapFlatMapExample(){

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

        studentOptional.filter(student ->  student.getGpa()>=3.5)
                .ifPresent(student -> System.out.println(student));

    }

    public static void optionalMap(){

        Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
        if(studentOptional.isPresent()){

            Optional<String> stringOptional = studentOptional.filter(student -> student.getGpa()>=3.5)
                    .map(Student::getName);




        }



    }

    public static void optionalFlatMap(){

        Optional<Student> studentOptional =

                Optional.ofNullable(StudentDataBase.studentSupplier.get());

      Optional<String> name=   studentOptional.filter(student -> student.getGpa()>=3.5)

                .flatMap(Student::getBike)
                .map(Bike::getName);

      name.ifPresent(s -> System.out.println(s));


    }

    public static void main(String[] args) {

        // isPresent
        //ifPresent

//        Optional<String> optional = Optional.ofNullable("hello Optional");
//
//        System.out.println(optional.isPresent());
//
//        if(optional.isPresent()){
//
//
//            System.out.println(optional.get());
//
//        }
//
//        //ifPresent
//        optional.ifPresent(s -> System.out.println(s));


       // optionalMapFlatMapExample();
     //   optionalMap();
optionalFlatMap();



    }


}
