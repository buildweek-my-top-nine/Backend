package com.lambdaschool.starthere.repository;

import com.lambdaschool.starthere.models.Category;
import com.lambdaschool.starthere.models.Interest;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>
{
    Category findByCategoryname(String name); // <-- added functionality
}
