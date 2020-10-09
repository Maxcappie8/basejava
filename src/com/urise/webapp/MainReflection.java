package com.urise.webapp;

import com.urise.webapp.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Deprecated
public class MainReflection {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("a");
        Field field = resume.getClass().getDeclaredFields()[0];
        field.setAccessible(true);
        System.out.println(field.getName());
        System.out.println(field.get(resume));
        field.set(resume, "new_uuid");
        field.setAccessible(false);
        // TODO : invoke r.toString via reflection
        Method toStringMethod = resume.getClass().getMethod("toString");
        System.out.println("invoke resume.toString - " + toStringMethod.invoke(resume));
    }
}