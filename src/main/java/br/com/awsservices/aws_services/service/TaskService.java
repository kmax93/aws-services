package br.com.awsservices.aws_services.service;

import br.com.awsservices.aws_services.entity.Task;
import br.com.awsservices.aws_services.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    public Task createTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return repository.findById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        return repository.findByStatus(status);
    }

    public Task updateTask(Long id, Task newTask) {
        return repository.findById(id)
            .map(task -> {
                task.setTitle(newTask.getTitle());
                task.setDescription(newTask.getDescription());
                task.setStatus(newTask.getStatus());
                return repository.save(task);
            }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}