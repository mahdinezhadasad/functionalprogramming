package configloader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayFlattening {

    public <T> T concat(Class<?> type, Object ... arguments){

        if(arguments.length == 0){


            return null;
        }

        List<Object> elements = new ArrayList<>();

        for(Object argument : arguments) {

            if (argument.getClass().isArray()) {


                int length = Array.getLength(argument);

                for (int i = 0; i < length; i++) {

                    elements.add(Array.get(argument, i));
                }


            }

            else {

                elements.add(argument);

            }
        }

        Object flattendArray = Array.newInstance(type,elements.size());

        for(int i = 0; i <elements.size();i++){

            Array.set(flattendArray,i,elements.get(i));


        }

         return (T) flattendArray;

          }
}
