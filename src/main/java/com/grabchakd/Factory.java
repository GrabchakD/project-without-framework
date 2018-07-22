package com.grabchakd;

import com.grabchakd.controller.GetAllCategoriesController;
import com.grabchakd.controller.GetCategoryById;
import com.grabchakd.controller.LoginController;
import com.grabchakd.controller.SignUpController;
import com.grabchakd.dao.CategoryDao;
import com.grabchakd.dao.CategoryDaoImpl;
import com.grabchakd.dao.UserDao;
import com.grabchakd.dao.UserDaoImpl;
import com.grabchakd.servise.CategoryService;
import com.grabchakd.servise.CategoryServiceImpl;
import com.grabchakd.servise.UserService;
import com.grabchakd.servise.UserServiceImpl;

import java.sql.Connection;
import java.sql.DriverManager;

public class Factory {

    static {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:h2:tcp://localhost/~/test",
                    "sa",
                    ""
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Connection connection;

    public static GetCategoryById getCategoryById() {
        return new GetCategoryById(getCategoryService());
    }

    public static GetAllCategoriesController getAllCategoriesController() {
        return new GetAllCategoriesController(getCategoryService());
    }

    public static UserDao getUserDaoImpl() {
        return new UserDaoImpl(connection);
    }

    public static SignUpController getSignUpController() {
        return new SignUpController(getUserService());
    }

    public static LoginController getLoginController() {
        return  new LoginController(getUserService());
    }

    private static UserService getUserService() {
        return new UserServiceImpl(getUserDaoImpl());
    }

    private static CategoryService getCategoryService() {
        return new CategoryServiceImpl(getCategoryDaoImpl());
    }

    private static CategoryDao getCategoryDaoImpl() {
        return new CategoryDaoImpl(connection);
    }


}
