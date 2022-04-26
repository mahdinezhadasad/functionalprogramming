package NumericStreams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumericStreamsBoxingUnboxingExample {


    public static List<Integer> boxing(){

       return IntStream.rangeClosed(1,10)
                .boxed()
                .collect(Collectors.toList());




    }

    public static int unboxing(List<Integer> integerList){

        //wrapper to primitive

        return integerList.stream()
                .mapToInt(Integer::intValue)// intstream
                .sum();


    }

    public static void main(String[] args) {


        System.out.println("Boxing : " + boxing());

        List<Integer> integerList =  boxing();

        System.out.println("Unboxing : " + unboxing(integerList));




    }
}
