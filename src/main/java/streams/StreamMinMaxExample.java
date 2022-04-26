package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMinMaxExample {



    public static int findMaxValue(List<Integer> integerList){

       return integerList.stream()
                .reduce(0,(x,y) -> x>y ? x:y);


    }

    public static Optional<Integer> findMinValue(List<Integer> integerList){

        return integerList.stream()
                .reduce((x,y) -> x<y ? x:y);


    }

    public static Optional<Integer> findMaxValueOptional(List<Integer> integerList){

        return integerList.stream()
                .reduce((x,y) -> x>y ? x:y);


    }

    public static void main(String[] args) {


         List<Integer> integerList = Arrays.asList(6,7,8,9,10);


         Optional<Integer> minValue = findMinValue(integerList);

        System.out.println("min value is " + minValue.get());
//
//        List<Integer> integerList = new ArrayList<>();
//
//        int maxValue = findMaxValue(integerList);
//
//        System.out.println("max value " + maxValue);
//
//        Optional<Integer> maxValueOptional = findMaxValueOptional(integerList);
//        if(maxValueOptional.isPresent()){
//
//
//            System.out.println("maxvalue optional is  " + maxValueOptional.get());
//        }
//        else {
//
//            System.out.println("No max Value found .");
//
//        }


    }
}
