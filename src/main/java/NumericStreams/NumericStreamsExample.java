package NumericStreams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class NumericStreamsExample {

    public static int sumOfNNumbers(List<Integer>  integerList){

        return  integerList.stream()
                .reduce(0,(x,y) -> x+y);


    }

    public static int sumOfNNumbersIntStream(){


        return IntStream.rangeClosed(1,6)
                .sum();
    }


    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7);


        System.out.println("Sum of Numberst  " + sumOfNNumbers(integers));


        System.out.println("sum of n number using IntStream : " + sumOfNNumbersIntStream());


    }
}
