package org.m4nn.taskws.controller;

import org.m4nn.taskws.model.Task;
import org.m4nn.taskws.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 


@RestController
@RequestMapping("/api/tasks") 
public class TaskController {

  private TaskService taskService;
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
    }


    @GetMapping(path = "/{id}")
    public Task getTask(@PathVariable("id") String id) {
        return taskService.getTask(id);
    }

    @PostMapping(path = "task")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    /* 
      @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Task> getTask(@PathVariable Long id) {
        Optional<Task> task = taskService.getTask(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Optional<Task> updatedTask = Optional.ofNullable(taskService.updateTask(id, task));
        return updatedTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        try {
            taskService.deleteTask(id);
            return ResponseEntity.ok().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/complete") 
    public ResponseEntity<Task> completeTask(@PathVariable Long id) {
        Optional<Task> completedTask = Optional.ofNullable(taskService.completeTask(id));
        return completedTask.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }  */
}
