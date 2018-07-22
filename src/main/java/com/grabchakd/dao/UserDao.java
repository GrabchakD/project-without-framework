package com.grabchakd.dao;

import com.grabchakd.model.User;

public interface UserDao {

    User getByToken(String token);

    User createUser(User user);

    User getById(Long id);

    User getByEmail(String email);

    void update(User user);

    User validateCredentials(String email, String password);
}
