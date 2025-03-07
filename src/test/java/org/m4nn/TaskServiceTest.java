package org.m4nn;

import org.junit.jupiter.api.Test;
import org.m4nn.taskws.model.Task;
import org.m4nn.taskws.service.TaskService;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TaskServiceTest {
    
    @Test
    public void testCreateTask() {
        TaskService taskService = new TaskService();
        Task task = new Task("1", "Task 1", "Description 1", false);
        Task createdTask = taskService.createTask(task);
        assertEquals(task, createdTask);
    }


}
