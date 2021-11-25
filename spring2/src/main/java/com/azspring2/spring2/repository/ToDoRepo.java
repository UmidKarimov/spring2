package com.azspring2.spring2.repository;

import com.azspring2.spring2.entity.ToDoEntity;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepo extends CrudRepository<ToDoEntity, Long> {
    ToDoEntity getTaskByTitle(String title);
}
