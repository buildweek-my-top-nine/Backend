package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.models.Category;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryService
{
    List<Category> findAll(Pageable pageable);

    Category save(Category category);

    void delete(long id);
}
