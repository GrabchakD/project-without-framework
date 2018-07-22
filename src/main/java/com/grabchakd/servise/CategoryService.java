package com.grabchakd.servise;

import com.grabchakd.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAll();

    Category getById(Long id);
}
