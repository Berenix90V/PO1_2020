package po1.it.unive.vehicle;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({
        ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER
})
public @interface Speed {
    String type() default "km/h";
    boolean forward();
}
