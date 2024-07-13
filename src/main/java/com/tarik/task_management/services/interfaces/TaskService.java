package com.tarik.task_management.services.interfaces;

import java.util.List;
import java.util.Optional;

import com.tarik.task_management.models.Task;

public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Optional<Task> getTaskById(Long id);
    Task updateTask(Long id, Task taskDetails);
    void deleteTask(Long id);
}
