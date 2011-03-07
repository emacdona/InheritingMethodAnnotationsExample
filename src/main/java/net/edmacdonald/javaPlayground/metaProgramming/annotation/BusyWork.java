package net.edmacdonald.javaPlayground.metaProgramming.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
public @interface BusyWork {
}
