package com.open.kanban.adapters.service;

import com.open.kanban.adapters.database.entities.TaskData;
import com.open.kanban.adapters.database.repository.TaskRepository;
import com.open.kanban.adapters.enums.TaskStatus;
import com.open.kanban.domain.exception.CException;
import com.open.kanban.domain.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository repository;

    @Override
    @Transactional
    public TaskData create(TaskData taskData) {
        try {
            return repository.save(taskData);
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error creating Task");
        }
    }

    @Override
    @Transactional
    public TaskData update(TaskData taskData) {
        try {
            if (existsById(taskData.getId())) {
                taskData.setUpdatedAt(LocalDateTime.now());
                return repository.save(taskData);
            }
            throw new CException("Task not found");
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error updating Task");
        }
    }

    @Override
    public TaskData findById(Long id) {
        try {
            return repository.findById(id)
                    .orElseThrow(() -> new CException("Task not found"));
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error getting Task");
        }
    }

    @Override
    public List<TaskData> findAll() {
        try {
            return repository.findAll();
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error getting Tasks");
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        try {
            if (existsById(id)) {
                repository.deleteById(id);
                return;
            }
            throw new CException("Task not found");
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error deleting Task");
        }
    }

    @Override
    public Boolean existsById(Long id){
        try {
            return repository.existsById(id);
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error checking if Task exists");
        }
    }

    @Override
    @Transactional
    public void changeStatus(Long id, String status){
        try {
            TaskData taskFounded = findById(id);
            taskFounded.setStatus(TaskStatus.valueOf(status));
            taskFounded.setUpdatedAt(LocalDateTime.now());
            repository.save(taskFounded);
            return;
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CException("Error changing task status");
        }
    }
}
