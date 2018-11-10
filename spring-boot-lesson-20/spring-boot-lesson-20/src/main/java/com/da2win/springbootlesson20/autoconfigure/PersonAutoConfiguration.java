package com.da2win.springbootlesson20.autoconfigure;

import com.da2win.springbootlesson20.controller.PersonRestController;
import com.da2win.springbootlesson20.domain.Person;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * {@link Person} 自动装配
 *
 * @Author Darwin
 * @Date 2018/11/10 15:41
 */
//@Configuration
@ConditionalOnProperty(prefix = "person", name = "enabled", havingValue = "true"/*, matchIfMissing = true*/)
@ConditionalOnWebApplication
public class PersonAutoConfiguration {


    @ConfigurationProperties(prefix = "person")
    @Bean
    public Person person() {
        return new Person();
    }

    //@Bean
    //public PersonRestController personRestController(Person person) {
    //    return new PersonRestController(person);
    //}
}
