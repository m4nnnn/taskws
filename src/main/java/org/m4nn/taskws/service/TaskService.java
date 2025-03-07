package org.m4nn.taskws.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.m4nn.taskws.model.Task;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    
    //@Autowired
   // private TaskRepository taskRepository;

   /* public List<Task> getAllTasks() {
        return taskRepository.findAll();
    } */
    private HashMap<String, Task> tasks = new HashMap<String, Task>();

    public Task getTask(String id) {
        return tasks.get(id);
    } 

    public List<Task> getTasks() {
        return new ArrayList<>(tasks.values());
    }


    public Task updateTask(String id, Task task) {
        if (tasks.containsKey(id)) {
            tasks.put(id, task);
            return task;
        }
        return null;
    }



    public Task createTask(Task task) {
        var uid = java.util.UUID.randomUUID().toString();
        task.setId(uid);
        tasks.put(task.getId(), task);

        return task;
    }

    public boolean deleteTask(String id) {
        if (tasks.containsKey(id)) {
            tasks.remove(id);
            return true;
        }
        return false;
    }


    /*public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Long id, Task task) {
        if (!taskRepository.existsById(id)) {
            return null;
        }
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    } */

}
