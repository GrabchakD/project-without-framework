package com.grabchakd.controller;

import com.grabchakd.model.User;
import com.grabchakd.servise.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController implements Controller {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("username");
        String password = req.getParameter("password");

        User user = userService.validateCredentials(email, password);

        try {
            if (user != null) {
                Cookie cookie = new Cookie("MyApp", user.getToken());
                resp.addCookie(cookie);
                req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
            } else {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
