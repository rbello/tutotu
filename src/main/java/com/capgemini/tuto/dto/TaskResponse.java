package com.capgemini.tuto.dto;

import com.capgemini.tuto.dal.Task;
import com.capgemini.tuto.dal.TaskStatus;

public class TaskResponse {

    private final Long id;
    private final String label;
    private final String comment;
    private final TaskStatus status;

    public TaskResponse(Task entity) {
        id = entity.getId();
        label = entity.getLabel();
        comment = entity.getComment();
        status = entity.getStatus();
    }

    public Long getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getComment() {
        return comment;
    }

    public TaskStatus getStatus() {
        return status;
    }

}
