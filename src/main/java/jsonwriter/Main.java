package jsonwriter;

import data.Address;
import data.Company;
import data.Person;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        Address address = new Address("Main Street",(short)1);
        Company company = new Company("Udemy","sanfransico",address);
        Person person = new Person("John",true,100.555f,address,company);

        String json = objectToJson(person,0);

        System.out.println(json);

    }

    private static String indent(int indentSize){

        StringBuilder stringBuilder = new StringBuilder();
        for(int i =0; i< indentSize;i++){
            stringBuilder.append("\t");



        }
        return stringBuilder.toString();


    }

    public static String objectToJson(Object instance,int identSize) throws IllegalAccessException {
        Field [] fields = instance.getClass().getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(indent(identSize));
        stringBuilder.append("{");
        stringBuilder.append("\n");

        for(int i =0; i< fields.length;i++){
            Field field =fields[i];

            field.setAccessible(true);

            if(field.isSynthetic()){

                continue;

            }
            stringBuilder.append(indent(identSize+1));
            stringBuilder.append(formatStringValue(field.getName()));
            stringBuilder.append(":");
            if(field.getType().isPrimitive()){

                stringBuilder.append(formatPrimitiveValue(field.get(instance),field.getType()));


            }
            else if(field.getType().equals(String.class)){

                stringBuilder.append(formatStringValue(field.get(instance).toString()));

            }
            else if(field.getType().isArray()){

                stringBuilder.append(arrayToJson(field.get(instance), identSize+1));

            }
            else{


                stringBuilder.append(objectToJson(field.get(instance),identSize+1));
            }

            if(i!=fields.length-1){

                stringBuilder.append(",");

            }

            stringBuilder.append("\n");

        }
        stringBuilder.append(indent(identSize));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    private static String arrayToJson(Object arrayInstance,int indentSize) throws IllegalAccessException {
        StringBuilder stringBuilder = new StringBuilder();
        int arrayLength = Array.getLength(arrayInstance);

        Class<?> componentType = arrayInstance.getClass().getComponentType();

        stringBuilder.append("[");
        stringBuilder.append("\n");

        for(int i =0; i< arrayLength; i++){
            Object  element = Array.get(arrayInstance,i);

            if(componentType.isPrimitive()){
                stringBuilder.append(indent(indentSize+1));

                stringBuilder.append(formatPrimitiveValue(element,componentType));
                        }

            else if(componentType.equals(String.class)){

                stringBuilder.append(indent(indentSize+1));

                stringBuilder.append(formatStringValue(element.toString()));


            }
            else{

                stringBuilder.append(objectToJson(element,indentSize+1));

            }
            if(i!=arrayLength-1){

                stringBuilder.append(",");


            }





        }
        stringBuilder.append("]");
        return stringBuilder.toString();




    }

    private static String formatPrimitiveValue(Object instance, Class<?> type)  {

        if(type.equals(boolean.class)
        || type.equals(int.class)
        ||type.equals(long.class)
        ||type.equals(short.class)
        ){


            return instance.toString();
        }
        else if(type.equals(double.class)||type.equals(float.class)){

            return String.format("%.02f",instance);
        }

        throw new RuntimeException(String.format("Type :  %s  is unsupported", type.getName()));
    }

    private static String formatStringValue(String value){


        return String.format("\"%s\"",value);
    }
}
