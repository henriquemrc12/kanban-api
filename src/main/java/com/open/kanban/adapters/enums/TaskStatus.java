package com.open.kanban.adapters.enums;

public enum TaskStatus {
    TO_DO,
    DOING,
    DONE;

    public static boolean contains(String status){
        for (TaskStatus taskStatus : TaskStatus.values()) {
            if (taskStatus.toString().equalsIgnoreCase(status.trim()))
                return true;
        }
        return false;
    }
}
