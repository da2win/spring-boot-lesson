package com.da2win.springbootlesson12;

import org.apache.commons.validator.routines.IntegerValidator;

import java.util.Locale;

public class ApacheCommonsValidatorMain {

    public static void main(String[] args) {
        IntegerValidator validator = new IntegerValidator();
        Integer value = validator.validate("10");
        System.out.println(value);
        value = validator.validate("a");
        System.out.println(value);
        System.out.println(validator.format(100000, Locale.ENGLISH));
    }
}
