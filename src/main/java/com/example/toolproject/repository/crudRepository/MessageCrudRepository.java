package com.example.toolproject.repository.crudRepository;

import com.example.toolproject.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message, Integer> {
}
