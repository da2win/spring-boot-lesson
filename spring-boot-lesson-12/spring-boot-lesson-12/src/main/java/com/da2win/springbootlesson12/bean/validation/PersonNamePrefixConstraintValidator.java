package com.da2win.springbootlesson12.bean.validation;

import com.da2win.springbootlesson12.bean.validation.constraints.PersonNamePrefix;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * {@link PersonNamePrefix} {@link ConstraintValidator}
 * @see PersonNamePrefix
 * @see ConstraintValidator
 */
public class PersonNamePrefixConstraintValidator implements ConstraintValidator<PersonNamePrefix, String> {
    private String prefix;

    @Override
    public void initialize(PersonNamePrefix constraintAnnotation) {
        this.prefix = constraintAnnotation.prefix();
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (!name.startsWith(prefix)) {

            context.disableDefaultConstraintViolation();

            context.buildConstraintViolationWithTemplate("人名必须必须以 \"" + prefix+ "\" 开头!");

            return false;
        }
        return true;
    }
}
