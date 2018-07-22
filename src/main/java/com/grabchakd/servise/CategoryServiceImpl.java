package com.grabchakd.servise;

import com.grabchakd.dao.CategoryDao;
import com.grabchakd.dao.CategoryDaoImpl;
import com.grabchakd.model.Category;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> getAll() {
        return categoryDao.getAll();
    }

    @Override
    public Category getById(Long id) {
        return categoryDao.getById(id);
    }


}
