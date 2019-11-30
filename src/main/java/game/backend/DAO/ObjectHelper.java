package game.backend.DAO;


import game.backend.models.Obj;
import org.apache.log4j.Logger;
import sun.net.www.content.text.Generic;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ObjectHelper {
    private static Logger logger = Logger.getLogger(SessionImpl.class);

    public static String[] getFields(Object entity) {

        Class theClass = entity.getClass();

        Field[] fields = theClass.getDeclaredFields();

        String[] sFields = new String[fields.length];
        int i=0;

        for (Field f: fields) sFields[i++]=f.getName();

        return sFields;

    }


    public static void setter(Object object, String property, Object value) { //DUBTS!!!!!!!!!!!!!
        //logger.debug("property: "+property);

        Class theClass = object.getClass();
        try {
           // logger.debug("value "+value.toString());
            //theMethod = theClass.getDeclaredMethod(setterMethod(property),value.getClass());
            Method[] allMethods = theClass.getMethods();
            for (Method m: allMethods) {
                logger.debug("value of setter "+setterMethod(property));
                if (!m.getName().equals(setterMethod(property))) {
//                    logger.debug("value "+value.toString());
//                    logger.debug("property:  "+property);

                    m.invoke(object, value); // For each method invoke and set in the object the value of each attribute

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


    }
    private static  String setterMethod(String property) {
        String setter = "set"+property.substring(0,1).toUpperCase()+property.substring(1);
        //logger.debug(setter);
        return setter;
    }


    private static  String getterMethod(String property) {
        String getter = "get"+property.substring(0,1).toUpperCase()+property.substring(1);
        logger.debug(getter);
        return getter;
    }

    public static Object getter(Object object, String property) {
        // Method // invoke

        logger.debug("property: "+property);

        Class theClass = object.getClass();
        Method theMethod = null;
        Object result = null;
        try {
            theMethod = theClass.getDeclaredMethod(getterMethod(property), null);
            result = theMethod.invoke(object);

            logger.debug("resultat "+ result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        return result;
    }
}
