package Streams_terminal;

import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {


    public static long checkPerformanceResult(Supplier<Integer> supplier, int numberOfTimes){

        long startTime = System.currentTimeMillis();

        for(int i = 0; i<numberOfTimes; i++){


            supplier.get();


        }

        long endTime = System.currentTimeMillis();

        return  endTime -startTime;


    }

    public static int sumSequentioalStream(){

        return IntStream.rangeClosed(1,10000)
                .sum();

    }


    public static int sumParallelStream(){


        return IntStream.rangeClosed(1,10000)
                .parallel()
                .sum();

    }


    public static void main(String[] args) {

        System.out.println(Runtime.getRuntime().availableProcessors());

        System.out.println("sequential Stream Result :  " +
                checkPerformanceResult(ParallelStreamExample::sumParallelStream,20));

        System.out.println("Parallel Stream Result :  " +
                checkPerformanceResult(ParallelStreamExample::sumSequentioalStream,20));


    }
}
