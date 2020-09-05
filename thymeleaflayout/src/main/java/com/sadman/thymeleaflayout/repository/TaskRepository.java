package com.sadman.thymeleaflayout.repository;

import com.sadman.thymeleaflayout.model.Task;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface TaskRepository  extends PagingAndSortingRepository<Task, Long> {
}
