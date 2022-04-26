package functionalprogramming;

import data.Student;
import data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {


        Supplier<Student>  studentSupplier = () -> {


            return  new Student("Mahdi",2,3.6,"Male", Arrays.asList("swimming","basketball","volleyball"));
        };

        System.out.println("new studen is : " + studentSupplier.get());


        Supplier<List<Student>> listSupplier = () -> StudentDataBase.getAllStudents();

        System.out.println("Student list is : " + listSupplier.get());
    }
}
