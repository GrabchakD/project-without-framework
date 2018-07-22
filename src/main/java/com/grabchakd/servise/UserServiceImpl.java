package com.grabchakd.servise;

import com.grabchakd.dao.UserDao;
import com.grabchakd.model.User;

import java.util.Objects;
import java.util.UUID;

public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User createUser(User user) {
        String hashedPassword = hashPassword(user.getPassword());
        user.setPassword(hashedPassword);
        user.setToken(generateToken());
        return userDao.createUser(user);
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User getByEmail(String email) {
        return userDao.getByEmail(email);
    }

    public User validateCredentials(String email, String password) {
        User user = getByEmail(email);

        String hashedPassword = hashPassword(password);

        if (user != null && user.getPassword().equals(hashedPassword)) {
            user.setToken(generateToken());
            userDao.update(user);
        }

        return user;
    }

    private String hashPassword (String password) {
        return String.valueOf(Objects.hash(password));
    }

    private String generateToken() {
        return UUID.randomUUID().toString();
    }
}
