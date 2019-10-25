package com.lambdaschool.starthere.services;

import com.lambdaschool.starthere.exceptions.ResourceFoundException;
import com.lambdaschool.starthere.logging.Loggable;
import com.lambdaschool.starthere.models.Category;
import com.lambdaschool.starthere.models.Interest;
import com.lambdaschool.starthere.repository.CategoryRepository;
import com.lambdaschool.starthere.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "categoryService")
public class CategoryServiceImpl implements CategoryService
{
    @Autowired
    private CategoryRepository categoryRepo;

    @Override
    public List<Category> findAll(Pageable pageable)
    {
        List<Category> list = new ArrayList<>();
        categoryRepo.findAll(pageable)
                .iterator()
                .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Category save(Category category)
    {
        if (categoryRepo.findByCategoryname(category.getCategoryname()) != null)
        {
            throw new ResourceFoundException(category.getCategoryname() + " is already taken! ");
        } else {
            Category newCategory = new Category();
            newCategory.setCategoryname(category.getCategoryname());

            return categoryRepo.save(newCategory);
        }
    }

    @Override
    public void delete(long id)
    {}
}
