package ru.javaops.webapp;

import ru.javaops.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLOutput;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        Resume r = new Resume();
        Field field = r.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(r));
        field.set(r,"new_uuid");
        System.out.println(r);

        Method method = r.getClass().getMethod("toString");
        Object result = method.invoke(r);
        System.out.println(result);

    }
}
