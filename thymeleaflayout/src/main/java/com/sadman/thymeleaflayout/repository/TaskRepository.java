package com.sadman.thymeleaflayout.repository;

import com.sadman.thymeleaflayout.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {
    Task findOne(Long id);
}
