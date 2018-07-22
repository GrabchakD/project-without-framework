package com.grabchakd;

import com.grabchakd.controller.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


public class MainServlet extends HttpServlet {

    private static Map<Request, Controller> controllerMap = new HashMap<>();


    @Override
    public void init() throws ServletException {
        controllerMap.put(new Request("GET", "/servlet/categories"), Factory.getAllCategoriesController());
        controllerMap.put(new Request("GET", "/servlet/category"), Factory.getCategoryById());
        controllerMap.put(new Request("POST", "/servlet/signup"), Factory.getSignUpController());
        controllerMap.put(new Request("GET", "/servlet/signup"), processView().apply("signup"));
        controllerMap.put(new Request("GET", "/servlet/login"), processView().apply("login"));
        controllerMap.put(new Request("POST", "/servlet/login"), Factory.getLoginController());
        controllerMap.put(new Request("GET", "/servlet/profile"), processView().apply("profile"));
        controllerMap.put(new Request("GET", "/servlet/logout"), this::processLogOut);
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Request request = new Request(req.getMethod(), req.getRequestURI());

        controllerMap.getOrDefault(request, processView().apply("404"))
        .process(req, resp);
    }

    private Function<String, Controller> processView() {

        return x -> (req, resp) -> {
            try {
                req.getRequestDispatcher(String.format("/WEB-INF/views/%s.jsp", x)).forward(req, resp);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        };
    }

    private void processSignUpView(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/signup/404.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private void processLogOut(HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookie = req.getCookies();

        for (Cookie c : cookie) {
            if (c.getName().equals("MyApp")) {
                resp.addCookie(new Cookie("MyApp", null));
                break;
            }
        }


        try {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
