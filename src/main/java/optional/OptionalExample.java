package optional;

import data.Student;
import data.StudentDataBase;

import java.util.Optional;

public class OptionalExample {


    public static String getStudentName(){

        Student student = StudentDataBase.studentSupplier.get();

        if(student!=null){

            return student.getName();

        }
        return null;


    }
    public static Optional<String> getStudentNameOptional(){

        Optional<Student>  studentOptional = Optional.ofNullable(null);

        if(studentOptional.isPresent()){



            return studentOptional.map(Student::getName);
        }

        return Optional.empty();


    }

    public static void main(String[] args) {

//        String name= getStudentName();
//
//        if(name!=null) {
//
//            System.out.println("Length of the student Name : " + name.length());
//        }
//        else {
//
//
//            System.out.println("Name not found");
//        }
//

        Optional<String> stringOptional = getStudentNameOptional();

        if(stringOptional.isPresent()){

            System.out.println("Length of student " + stringOptional.get().length()); // String which is Student Name

        }else{


            System.out.println("Name not found");
        }


    }




}
