package com.hiya.se.annotation.example;

import java.lang.reflect.Method;

public class NobugCheckExecutor
{
    public static void main(String[] args)
    {
        ShopService testobj = new ShopService();
        Class<? extends ShopService> clazz = testobj.getClass();
        Method[] method = clazz.getDeclaredMethods();
        StringBuilder log = new StringBuilder();
        int errornum = 0;
        for (Method m : method)
        {
            if (m.isAnnotationPresent(NobugCheck.class))
            {
                try
                {
                    m.setAccessible(true);
                    m.invoke(testobj, null);
                } catch (Exception e)
                {
                    errornum++;
                    log.append(m.getName());
                    log.append(" ");
                    log.append("has error:");
                    log.append("\n\r  caused by ");
                    log.append(e.getCause().getClass().getSimpleName());
                    log.append("\n\r");
                    log.append(e.getCause().getMessage());
                    log.append("\n\r");
                }
            }
        }
        log.append(clazz.getSimpleName());
        log.append(" has  ");
        log.append(errornum);
        log.append(" error.");
        System.out.println(log.toString());
    }
}
