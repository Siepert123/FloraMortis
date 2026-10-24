package trifectumsoftware.floramortis.util;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//Notify the IDE that the marked thing is in fact not unused at all but simply not accessed per conventional means
@Retention(RetentionPolicy.SOURCE)
public @interface NoUnused {
}
