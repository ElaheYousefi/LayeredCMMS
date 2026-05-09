package dadeAndisheNiroo.task.repository;

import dadeAndisheNiroo.task.model.AssignTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AssignedTaskRepository extends JpaRepository<AssignTask, Integer> {

    @Query(value="select at from AssignTask at where at.active= 1")
    List<AssignTask> findActiveTasks();

}
