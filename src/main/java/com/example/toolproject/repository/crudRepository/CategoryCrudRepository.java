package com.example.toolproject.repository.crudRepository;

import com.example.toolproject.entities.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {
}
