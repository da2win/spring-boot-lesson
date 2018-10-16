package com.da2win.springbootlesson12.validator;

import com.da2win.springbootlesson12.domain.Person;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 */
public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = Person.class.cast(target);

        String name = person.getName();

        if (!StringUtils.hasLength(name)) {

            errors.reject("person.name.not.null", "人的姓名不能为空");
        }

    }
}
