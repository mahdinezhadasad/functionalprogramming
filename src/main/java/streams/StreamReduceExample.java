package streams;

import data.Student;
import data.StudentDataBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {


    public static int perfomMultiplication(List<Integer> integerList){

      return   integerList.stream()
                //1
                //3
                //5
                //7
                // a=1 ,b=1 (from stream) -> result 1 is returend.
                // a = 1 ,b=3 (from stream)-> result is 3 returened.
                .reduce(1,(a,b) -> a*b);

    }

    public static Optional<Integer> perfomMultiplicationWithoutIdenitiy(List<Integer> integerList){

        return   integerList.stream()
                //1
                //3
                //5
                //7
                // a=1 ,b=1 (from stream) -> result 1 is returend.
                // a = 1 ,b=3 (from stream)-> result is 3 returened.
                .reduce((a,b) -> a*b);
    }

    public static Optional<Student>  getHighesGPAStudent(){

        return StudentDataBase.getAllStudents().stream().
                reduce(
                        (s1,s2) -> (s1.getGpa()>s2.getGpa()) ? s1: s2
                );
    }

    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,3,5,7);
        List<Integer> integers1 = new ArrayList<>();
     //   System.out.println(perfomMultiplication(integers));
       Optional<Integer> result =  perfomMultiplicationWithoutIdenitiy(integers);
        System.out.println(result.isPresent());
        System.out.println(result.get());
        Optional<Integer> result1 = perfomMultiplicationWithoutIdenitiy(integers1);
       // System.out.println(result1.isPresent());
        if(result1.isPresent()){
            System.out.println(result1.get());
        }


        Optional<Student>  studentOptional = getHighesGPAStudent();





        if(getHighesGPAStudent().isPresent()){


            System.out.println(studentOptional.get());
        }

    }
}
