package com.tsunderebug.smw.frame;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Mod {

    String id();
    String name();
    String version();

}
