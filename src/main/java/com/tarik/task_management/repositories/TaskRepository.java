package com.tarik.task_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tarik.task_management.models.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
