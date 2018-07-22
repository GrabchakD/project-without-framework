package com.grabchakd.servise;

import com.grabchakd.model.User;

public interface UserService {
    User createUser(User user);

    User getById(Long id);

    User getByEmail(String email);

    public User validateCredentials(String email, String password);
}
