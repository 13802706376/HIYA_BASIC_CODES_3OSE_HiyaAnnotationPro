package com.hiya.se.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(Persons.class)
public @interface Person
{
    String roleName() default  "Common";
}
