package functionalprogramming;

import java.util.function.Predicate;

public class PredicateExample {
    static   Predicate<Integer> p = (i) -> {return  i%2==0;};
    static   Predicate<Integer> p1 = (i) ->   i%2==0;
    static   Predicate<Integer> p2 = (i) ->   i%5==0;

     public static void predicateAnd(){


         System.out.println("predicate result is "+p1.and(p2).test(10));
         System.out.println("predicate result is "+p1.and(p2).test(9));

     }


    public static void main(String[] args) {



        System.out.println(p.test(4));

        predicateAnd();





    }
}
