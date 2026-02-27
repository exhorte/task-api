package sn.isi.l3gl.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sn.isi.l3gl.core.entity.Task;
import sn.isi.l3gl.core.enums.TaskStatus;
import sn.isi.l3gl.core.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    // POST /api/tasks → Créer une tâche
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.createTask(task));
    }

    // GET /api/tasks → Lister toutes les tâches
    @GetMapping
    public ResponseEntity<List<Task>> listTasks() {
        return ResponseEntity.ok(taskService.listTasks());
    }

    // PUT /api/tasks/{id}/status → Modifier le statut
    @PutMapping("/{id}/status")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id,
            @RequestParam TaskStatus status) {
        return ResponseEntity.ok(taskService.updateStatus(id, status));
    }

    // GET /api/tasks/done/count → Compter les tâches DONE
    @GetMapping("/done/count")
    public ResponseEntity<Long> countCompletedTasks() {
        return ResponseEntity.ok(taskService.countCompletedTasks());
    }
}