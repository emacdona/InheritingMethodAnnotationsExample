package net.edmacdonald.javaPlayground.metaProgramming;

import net.edmacdonald.javaPlayground.metaProgramming.annotation.BusyWork;
import net.edmacdonald.javaPlayground.metaProgramming.util.Utils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class NewtonTest {

    private Log log = LogFactory.getLog(NewtonTest.class);

    @Test
    public void doesBusyWorkTest() throws Exception {
        Newton isaac = new Newton();

        Assert.assertNotNull(isaac.writeBook());

        log.debug("Book: " + isaac.writeBook());

        Assert.assertFalse(naiveBusyWorkCheck(isaac));
        Assert.assertTrue(doesBusyWork(isaac));
    }

    private boolean doesBusyWork(Object obj){
        for(Method method: obj.getClass().getMethods()){
            if(Utils.isImplementedMethodAnnotatedWith(method, BusyWork.class)){
                return true;
            }
        }

        return false;
    }

    private boolean naiveBusyWorkCheck(Object obj){
        for(Method method: obj.getClass().getMethods()){
           if(method.isAnnotationPresent(BusyWork.class)){
               return true;
           }
        }

        return false;
    }
}
