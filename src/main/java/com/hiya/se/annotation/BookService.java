package com.hiya.se.annotation;

import java.util.Arrays;
import java.util.List;

public class BookService
{
    //标记过时的元素
    @Deprecated
    public static void say()
    {
        System.out.println("Noting has to say!");
    }

    public static void speak()
    {
        System.out.println("I have a dream!");
    }
    
    static void m(List<String>... stringLists) 
    {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

}
