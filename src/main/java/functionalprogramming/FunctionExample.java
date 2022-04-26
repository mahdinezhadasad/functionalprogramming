package functionalprogramming;

import java.util.function.Function;

public class FunctionExample {


    static Function<String,String> function = (name)-> name.toUpperCase();
    static Function<String,String> functionString = (name)-> name.toUpperCase().concat("default");


    public static void main(String[] args) {


        System.out.println("Result is : " + function.apply("java8"));

        System.out.println("Result of andthen is : " + function.andThen(functionString).apply("java8"));

        System.out.println("Result of compose is : " + function.compose(functionString).apply("java8"));




    }
}
