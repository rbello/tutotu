package com.capgemini.tuto.srv;

import com.capgemini.tuto.dal.TaskRepository;
import com.capgemini.tuto.dto.TaskResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;


    @Transactional
    public List<TaskResponse> getTasks() {
        return StreamSupport
                .stream(taskRepository.findAll().spliterator(), false)
                .map(TaskResponse::new)
                .collect(Collectors.toList());
    }

}
