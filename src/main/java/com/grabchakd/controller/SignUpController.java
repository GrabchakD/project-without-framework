package com.grabchakd.controller;

import com.grabchakd.model.User;
import com.grabchakd.servise.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SignUpController implements Controller {

    private final UserService userService;

    public SignUpController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        User user = getUser(req);
        userService.createUser(user);
    }

    private User getUser(HttpServletRequest req) {
        String fistName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String token = req.getParameter("token");

        return  new User(fistName, lastName, email, password, token);
    }
}
