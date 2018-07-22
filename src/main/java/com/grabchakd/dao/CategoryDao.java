package com.grabchakd.dao;

import com.grabchakd.model.Category;
import com.grabchakd.model.Product;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getById(Long id);
}
