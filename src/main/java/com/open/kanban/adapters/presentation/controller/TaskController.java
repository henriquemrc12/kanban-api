package com.open.kanban.adapters.presentation.controller;

import com.open.kanban.adapters.presentation.mapper.TaskMapper;
import com.open.kanban.adapters.presentation.request.TaskCreateRequest;
import com.open.kanban.adapters.presentation.request.TaskUpdateRequest;
import com.open.kanban.adapters.presentation.validation.TaskValidation;
import com.open.kanban.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/task")
@RestController
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody TaskCreateRequest request) {
        TaskValidation.validate(request);
        return ResponseEntity.ok().body(service.create(TaskMapper.map(request)));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody TaskUpdateRequest request) {
        TaskValidation.validate(request);
        return ResponseEntity.ok().body(service.update(TaskMapper.map(request)));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}/{newStatus}")
    public ResponseEntity<?> changeStatus(@PathVariable Long id, @PathVariable String newStatus) {
        TaskValidation.validate(newStatus);
        service.changeStatus(id, newStatus);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
