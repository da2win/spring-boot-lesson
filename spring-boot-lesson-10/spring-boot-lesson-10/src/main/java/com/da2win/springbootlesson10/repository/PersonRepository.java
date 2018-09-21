package com.da2win.springbootlesson10.repository;

import com.da2win.springbootlesson10.entity.Person;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.NoRepositoryBean;

/**
 *  人员仓库
 */
@NoRepositoryBean
public interface PersonRepository {

    @Cacheable(cacheNames = "persons")
    Person findPerson(String id);

    boolean savePerson(Person person);
}
