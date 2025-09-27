package com.msrocketseat.service_task.repository;

import com.msrocketseat.service_task.domain.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

    @Query("SELECT t FROM TaskEntity t WHERE t.dueDate <= :deadLine AND t.notified = false")
    List<TaskEntity> findTasksDueWithinDeadline(LocalDateTime deadLine);
}
