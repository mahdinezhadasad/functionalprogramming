package constructors;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        //printConstructorData(Person.class);

        Address address = (Address) createInstanceWithArguments(Address.class,"First Street",10);

        Person person = (Person) createInstanceWithArguments(Person.class,address,"John",20);

        System.out.println(person);

    }

    public static Object createInstanceWithArguments(Class<?> clazz, Object ... args) throws InvocationTargetException, InstantiationException, IllegalAccessException {

        for(Constructor<?> constructor : clazz.getConstructors()){

            if(constructor.getParameterTypes().length ==args.length){

                return constructor.newInstance(args);





            }





        }
        System.out.println("An appropriate constructor was not found");
        return null;

    }

    public static void printConstructorData(Class<?> clazz){

        Constructor<?>[] constructors = clazz.getConstructors();
        System.out.println(String.format("class %s has %d declared constructors",clazz.getSimpleName(),constructors.length));
        for(int i=0; i<constructors.length;i++){

            Class<?>[] parameterTypes = constructors[i].getParameterTypes();

            List<String> parameterTypesNames = Arrays.stream(parameterTypes)
                    .map(type->type.getSimpleName())
                    .collect(Collectors.toList());

            System.out.println(parameterTypesNames);




        }





    }

    public static class Person{

        private final Address address;
        private final String name;
        private final int age;

        @Override
        public String toString() {
            return "Person{" +
                    "address=" + address +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public Person(Address address, String name, int age) {
            this.address = address;
            this.name = name;
            this.age = age;
        }

        public Person(){
            this.name = "annoymous";
            this.age=0;
            this.address = null;


        }
        public Person(String name){
            this.name = name;
            this.age=0;
            this.address = null;


        }
        public Person(String name,int age){
            this.name = name;
            this.age=age;
            this.address = null;


        }






    }


    public static class Address{

        private String street;
        private int number;

        public Address(String street,int number){

            this.street = street;
            this.number = number;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "street='" + street + '\'' +
                    ", number=" + number +
                    '}';
        }
    }


}
