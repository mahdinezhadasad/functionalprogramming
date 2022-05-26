package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ProductTest {

    public static void main(String[] args) {


    }

    public static void testGetters(Class<?>  dataClass){

        Field[] fields = dataClass.getDeclaredFields();

        Map<String, Method>  methodNameToMethod = mapMethodNameToMethod(dataClass);

        for (Field field : fields){

            String getterName = "get" + captilazeFirstLetter(field.getName());


            if(!methodNameToMethod.containsKey(gettername)){

                throw new IllegalStateException(String.format("Field : %s doesnt have a getter method",field.getName()));

            }

            Method getter = methodNameToMethod.get(getterName);

            if(!getter.getReturnType().equals(field.getType())){

                String.format("Getter method : %s() has return type %s but expected %s",getter.getName(),
                        getter.getReturnType().getTypeName(),
                        field.getType().getTypeName());

            }



        }



    }

    private static Map<String, Method> mapMethodNameToMethod(Class<?>  dataClass){


        Method [] allMethods = dataClass.getMethods();

        Map<String,Method>  nameToMethod = new HashMap<>();


        for(Method method : allMethods){


            nameToMethod.put(method.getName(),method);



        }
         return  nameToMethod;


    }
}
