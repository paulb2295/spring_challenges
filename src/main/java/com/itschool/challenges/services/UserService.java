package com.itschool.challenges.services;

import com.itschool.challenges.models.User;

import java.util.UUID;

public interface UserService {

    User createUser(User user);

    User getUser(UUID id);

}
