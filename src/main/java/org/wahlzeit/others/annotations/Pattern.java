package org.wahlzeit.others.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface Pattern{
    String patternName();
    Class[] participants();
}
