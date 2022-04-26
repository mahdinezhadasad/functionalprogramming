package functionalprogramming;

public class FunctionExample1 {


    public static String performConCat(String str){


        return FunctionExample.functionString.apply(str);

    }

    public static void main(String[] args) {

        String result  = performConCat("Hello");

        System.out.println("Result : " + result);

    }
}
