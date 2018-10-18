package com.da2win.springbootlesson14;

import com.da2win.springbootlesson14.domain.User;
import com.da2win.springbootlesson14.domain.UserIdRequest;
import com.da2win.springbootlesson14.domain.UserResponse;
import com.da2win.springbootlesson14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * 用户服务Endpoint
 */
@Endpoint
public class UserServiceEndpoint {

    @Autowired
    private UserRepository userRepository;

    @PayloadRoot(namespace = "http://segmentfault.com/schemas", localPart = "UserIdRequest")
    @ResponsePayload
    public UserResponse getUser(@RequestPayload UserIdRequest request) {
        long userId = request.getUserId();

        Instant instant = Instant.ofEpochMilli(request.getTimestamp());
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
        System.out.println("Web Services 用户 ID : " + userId + ",请求的时间 : " + zonedDateTime);

        User user = userRepository.findById(userId);

        UserResponse userResponse = new UserResponse();

        userResponse.setUser(user);

        userResponse.setTimestamp(Instant.now().toEpochMilli());

        return userResponse;
    }

}
