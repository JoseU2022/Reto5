package com.example.toolproject.repository.crudRepository;

import com.example.toolproject.entities.Tool;
import org.springframework.data.repository.CrudRepository;

public interface ToolCrudRepository extends CrudRepository<Tool, Integer> {
}
