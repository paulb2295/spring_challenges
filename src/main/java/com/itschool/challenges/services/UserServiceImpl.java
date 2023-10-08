package com.itschool.challenges.services;

import com.itschool.challenges.models.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    private List<User> userList = new ArrayList<>();

    @Override
    public User createUser(User user) {
        user.setUserId(UUID.randomUUID());
        user.setAccountCreatedIn(LocalDateTime.now());
        userList.add(user);
        return user;
    }

    @Override
    public User getUser(UUID id) {
        for (User user : userList) {
            if (user.getUserId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}
