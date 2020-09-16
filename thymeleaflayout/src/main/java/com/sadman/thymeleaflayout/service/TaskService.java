package com.sadman.thymeleaflayout.service;

import com.sadman.thymeleaflayout.model.Task;
import com.sadman.thymeleaflayout.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepository;

//    @PostConstruct
//    private void init() {
//        taskRepository.save(new Task("Shopping", "Buy Milk and Butter...", "2017.01.01 13:22:42"));
//        taskRepository.save(new Task("Books", "Read 'Lords of The Ring'", "2017.01.02 15:22:42"));
//    }

    public Iterable<Task> findAll() {
        return taskRepository.findAll();
    }

    public Optional<Task> findOne(Long id) {
        return taskRepository.findById(id);
    }
}
