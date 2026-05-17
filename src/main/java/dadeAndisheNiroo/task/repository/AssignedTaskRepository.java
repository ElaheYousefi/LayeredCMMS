package dadeAndisheNiroo.task.repository;

import dadeAndisheNiroo.task.AssignTaskStatus;
import dadeAndisheNiroo.task.model.AssignTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AssignedTaskRepository extends JpaRepository<AssignTask, Integer> {

    @Query(value="select at from AssignTask at where at.active= 1 and at.nextExecutionDate<= current_date and at.status is null")
    List<AssignTask> findReadyTasks();

    @Transactional
    @Modifying
    @Query(value="update AssignTask d set d.status= ?2 where d.id= ?1")
    void updateAssignTaskStatus(Integer id, AssignTaskStatus sent);
}
