package net.edmacdonald.javaPlayground.metaProgramming.util;

import org.apache.commons.lang.ArrayUtils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utils {
    public static boolean isImplementedMethodAnnotatedWith(Method method, Class annotation) {
        Class[] clazzes = getAllInterfaces(method.getDeclaringClass());

        for(Class clazz : clazzes) {
            try {
                //Throws an exception if method not found.
                Method m = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());

                if(m.isAnnotationPresent(annotation)) {
                    return true;
                }
            }
            catch(Exception e) {
                /*Do nothing*/
            }
        }

        return false;
    }

    private static Class[] getAllInterfaces(Class clazz) {
        return getAllInterfaces(new Class[] { clazz } );
    }

    private static Class[] getAllInterfaces(Class[] classes) {
        if(0 == classes.length ) {
            return classes;
        }
        else {
            List<Class> extendedClasses = new ArrayList<Class>();
            for (Class clazz: classes) {
                extendedClasses.addAll(Arrays.asList( clazz.getInterfaces() ) );
            }
            //Class::getInterfaces() gets only interfaces/classes implemented/extended directly by a given class.
            //We need to walk the whole way up the tree.
            return (Class[]) ArrayUtils.addAll( classes,
                                                getAllInterfaces(
                                                        extendedClasses.toArray(new Class[extendedClasses.size()]))
            );
        }
    }
}
