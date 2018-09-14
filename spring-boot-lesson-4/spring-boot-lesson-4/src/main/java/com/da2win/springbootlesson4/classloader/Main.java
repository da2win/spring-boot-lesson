package com.da2win.springbootlesson4.classloader;

public class Main {

    public static void main(String[] args) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        while (true) {
            System.out.println(contextClassLoader.getClass().getName());
            contextClassLoader = contextClassLoader.getParent();
            if (contextClassLoader == null) {
                break;
            }
        }
    }
}
