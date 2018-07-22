package com.grabchakd.controller;

import com.grabchakd.servise.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class GetAllCategoriesController implements Controller {

    private CategoryService categoryService;

    public GetAllCategoriesController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("categories", categoryService.getAll());

        try {
            req.getRequestDispatcher("/WEB-INF/views/categories.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
