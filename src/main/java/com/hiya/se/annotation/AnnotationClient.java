package com.hiya.se.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class AnnotationClient
{
    @SuppressWarnings("deprecation")
    public static void main(String[] args)
    {
        BookService.say();
        BookService.speak();
        boolean hasAnnotation = Book.class.isAnnotationPresent(HiyaAnnotation.class);
        if (hasAnnotation)
        {
            HiyaAnnotation testAnnotation = Book.class.getAnnotation(HiyaAnnotation.class);
            System.out.println("id:" + testAnnotation.id());
            System.out.println("msg:" + testAnnotation.msg());
        }
        try
        {
            Field a = Book.class.getDeclaredField("a");
            a.setAccessible(true);
            HiyaAnnotationValue check = a.getAnnotation(HiyaAnnotationValue.class);
            if (check != null)
            {
                System.out.println("check value:" + check.value());
            }
            Method testMethod = Book.class.getDeclaredMethod("testMethod");
            if (testMethod != null)
            {
                Annotation[] ans = testMethod.getAnnotations();
                for (int i = 0; i < ans.length; i++)
                {
                    System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
                }
            }
        } catch (NoSuchFieldException e)
        {
            System.out.println(e.getMessage());
        } catch (SecurityException e)
        {
            System.out.println(e.getMessage());
        } catch (NoSuchMethodException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
