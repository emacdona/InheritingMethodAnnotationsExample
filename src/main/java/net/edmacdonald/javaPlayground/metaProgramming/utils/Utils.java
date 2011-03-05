package net.edmacdonald.javaPlayground.metaProgramming.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.ArrayUtils;

public class Utils {
        private boolean isImplementedMethodAnnotatedWithPath(Method method, Annotation annotation)
        {
            Class[] clazzes = getAllInterfaces(method.getDeclaringClass());

            for(Class clazz : clazzes)
            {
                try
                {
                    //Throws an exception if method not found.
                    Method m = clazz.getDeclaredMethod(method.getName(), method.getParameterTypes());

                    if(null != m.getAnnotation(annotation.getClass()))
                    {
                        return true;
                    }
                }
                catch(Exception e)
                {
                    /*Do nothing*/
                }
            }

            return false;
        }

        /**
         * Gets all classes/interfaces explicitly extended/implemented by the given Class and its explicit hierarchy.
         * The array returned will have classes in order of "closness" to the given Class in the class hierarchy.
         *
         * "explicitly" implies that java.lang.Object won't be included in the array (unless you explicitly extend
         * it -- you pedant).
         *
         * @param clazz
         * @return
         */
        private Class[] getAllInterfaces(Class clazz)
        {
            return getAllInterfaces(new Class[] { clazz } );
        }

        private Class[] getAllInterfaces(Class[] classes)
        {
            if(0 == classes.length )
            {
                return classes;
            }
            else
            {
                List<Class> extendedClasses = new ArrayList<Class>();
                for (Class clazz: classes)
                {
                    extendedClasses.addAll(Arrays.asList( clazz.getInterfaces() ) );
                }
                //Class::getInterfaces() gets only interfaces/classes implemented/extended directly by a given class.
                //We need to walk the whole way up the tree.
                return (Class[]) ArrayUtils.addAll(  classes,
                                           getAllInterfaces(extendedClasses.toArray(new Class[extendedClasses.size()])));
            }
        }
    }

}
