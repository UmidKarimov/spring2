package com.azspring2.spring2.service;

import com.azspring2.spring2.entity.ToDoEntity;
import com.azspring2.spring2.exceptions.UserAlreadyExistsException;
import com.azspring2.spring2.model.ToDoModel;
import com.azspring2.spring2.repository.ToDoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {

    @Autowired
    private ToDoRepo toDoRepo;


    public ToDoModel addToDoTask(ToDoEntity task) throws UserAlreadyExistsException {
        if (toDoRepo.getTaskByTitle(task.getTitle()) != null) {
            throw new UserAlreadyExistsException("Task with this name <"+task.getTitle() + "> already exists!");
        }
        return ToDoModel.toModel(toDoRepo.save(task));
    }
}
