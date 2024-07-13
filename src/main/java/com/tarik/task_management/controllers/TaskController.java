package com.tarik.task_management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tarik.task_management.exceptions.TaskNotFoundException;
import com.tarik.task_management.models.Task;
import com.tarik.task_management.services.TaskServiceImpl;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskServiceImpl taskService;

    @Autowired
    public TaskController(TaskServiceImpl taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
        Task createdTask = taskService.createTask(task);
        return ResponseEntity.ok(createdTask);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new TaskNotFoundException("Task not found with id: " + id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task taskDetails){
        Task updatedTask = taskService.updateTask(id, taskDetails);
        return ResponseEntity.ok(updatedTask);
    }

    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
