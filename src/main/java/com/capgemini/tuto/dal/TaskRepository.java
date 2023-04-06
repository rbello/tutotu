package com.capgemini.tuto.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {
    Optional<Task> findByLabel(String test);

    List<Task> findByStatus(TaskStatus todo);

}
