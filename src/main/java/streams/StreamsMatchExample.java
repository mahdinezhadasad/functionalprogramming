package streams;

import data.StudentDataBase;

public class StreamsMatchExample {

    public static boolean allmtach(){

        return StudentDataBase.getAllStudents().stream()
                .allMatch(student -> student.getGpa()>=3.5);


    }

    public static boolean anymatch(){

        return StudentDataBase.getAllStudents().stream()
                .anyMatch(student -> student.getGpa()>=4.1);


    }



    public static boolean nonmatch(){

        return StudentDataBase.getAllStudents().stream()
                .noneMatch(student -> student.getGpa()>=4.1);


    }


    public static void main(String[] args) {



        System.out.println("print all mach " + allmtach());
        System.out.println("print all anymach " + anymatch());
        System.out.println("nont match " +  nonmatch() );


    }
}
