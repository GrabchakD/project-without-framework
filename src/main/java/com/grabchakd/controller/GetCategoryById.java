package com.grabchakd.controller;

import com.grabchakd.servise.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCategoryById implements Controller {

    private CategoryService categoryService;

    public GetCategoryById(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void process(HttpServletRequest req, HttpServletResponse resp) {
        Long id = Long.parseLong(req.getParameter("c_id"));
        req.setAttribute("category", categoryService.getById(id));

        try {
            req.getRequestDispatcher("/WEB-INF/views/category.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
