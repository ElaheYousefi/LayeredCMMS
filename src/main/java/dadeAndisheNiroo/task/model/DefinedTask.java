package dadeAndisheNiroo.task.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class DefinedTask {

    @Id
    @GeneratedValue
    private int id;
    private String taskName;
    private LocalDate endDate;
    private int periodDay;
    private LocalDate startDate;
    @OneToMany(mappedBy = "definedTask")
    private List<AssignTask> assignTaskList;

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public int getPeriodDay() {
        return periodDay;
    }

    public void setPeriodDay(int periodDay) {
        this.periodDay = periodDay;
    }

    public List<AssignTask> getAssignTaskList() {
        return assignTaskList;
    }

    public void setAssignTaskList(List<AssignTask> assignTaskList) {
        this.assignTaskList = assignTaskList;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
