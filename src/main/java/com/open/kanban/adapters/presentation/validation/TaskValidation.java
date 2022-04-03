package com.open.kanban.adapters.presentation.validation;

import com.open.kanban.adapters.enums.TaskStatus;
import com.open.kanban.adapters.presentation.request.TaskCreateRequest;
import com.open.kanban.adapters.presentation.request.TaskUpdateRequest;
import com.open.kanban.domain.exception.CException;

import java.util.ArrayList;
import java.util.List;

public class TaskValidation {

    public static void validate(TaskCreateRequest request){
        try {
            List<String> errorList = new ArrayList<>();

            // Required verification
            if(request.getTitle() == null || request.getTitle().isBlank()) {
                String error = "'title' is required";
                errorList.add(error);
            }

            if(request.getDescription() == null || request.getDescription().isBlank()) {
                String error = "'description' is required";
                errorList.add(error);
            }

            if(errorList.size() > 0)
                throw new CException(errorList);

            // Field verification
            if(request.getTitle().length() > 45) {
                String error = "'title' can not contain more than 45 characters";
                errorList.add(error);
            }

            if(request.getDescription().length() > 1000) {
                String error = "'description' can not contain more than 1000 characters";
                errorList.add(error);
            }

            if(errorList.size() > 0)
                throw new CException(errorList);

        } catch (CException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void validate(TaskUpdateRequest request){
        try {
            List<String> errorList = new ArrayList<>();

            // Required verification
            if(request.getId() == null) {
                String error = "'id' is required";
                errorList.add(error);
            }

            if(request.getTitle() == null || request.getTitle().isBlank()){
                String error = "'title' is required";
                errorList.add(error);
            }

            if(request.getDescription() == null || request.getDescription().isBlank()){
                String error = "'description' is required";
                errorList.add(error);
            }

            if(request.getStatus() == null || request.getStatus().isBlank()){
                String error = "'status' is required";
                errorList.add(error);
            }

            if(errorList.size() > 0)
                throw new CException(errorList);

            // Field verification
            if(request.getTitle().length() > 45) {
                String error = "'title' can not contain more than 45 characters";
                errorList.add(error);
            }

            if(request.getDescription().length() > 1000) {
                String error = "'description' can not contain more than 1000 characters";
                errorList.add(error);
            }

            if(errorList.size() > 0)
                throw new CException(errorList);
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void validate(String status){
        try {
            boolean isValidStatus = TaskStatus.contains(status);
            if (!isValidStatus)
                throw new CException(String.format("'%s' is not a valid Status", status));
            return;
        } catch (CException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
