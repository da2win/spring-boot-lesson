package com.da2win.springbootlesson14.repository;

import com.da2win.springbootlesson14.domain.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户的仓储
 */
@Repository
public class UserRepository {

    private Map<Long, User> cachedUsers = new HashMap<>();

    @PostConstruct
    public void init() {
        User user1 = createUser(1, "达尔文", 24);
        User user2 = createUser(1, "赫胥黎", 24);
        User user3 = createUser(1, "加尔文", 24);
        cachedUsers.put(1L, user1);
        cachedUsers.put(2L, user2);
        cachedUsers.put(3L, user3);
    }
    public User findById(long id) {
        return cachedUsers.get(id);
    }

    private User createUser(long id, String name, Integer age) {
        User user  = new User();

        user.setId(id);
        user.setName(name);
        user.setAge(age);

        return user;
    }

}
