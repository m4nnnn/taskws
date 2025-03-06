package org.m4nn.taskws.service;

import org.m4nn.taskws.model.*;
import org.m4nn.taskws.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Task updateTask(Long id, Task task) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            task.setId(existingTask.get().getId());
            return taskRepository.save(task);
        }
        return null;
    }

    public Task completeTask(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if (task.isPresent()) {
            Task completedTask = task.get();
            completedTask.setCompleted(true); // Assuming Task has a setCompleted method
            return taskRepository.save(completedTask);
        }
        return null;
    }
}