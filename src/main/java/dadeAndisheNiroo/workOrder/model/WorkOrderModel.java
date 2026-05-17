package dadeAndisheNiroo.workOrder.model;

import dadeAndisheNiroo.employee.model.EmployeeModel;
import dadeAndisheNiroo.equipment.EquipStatus;
import dadeAndisheNiroo.task.model.AssignTask;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="workorder")
public class WorkOrderModel {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="assigntask_id")
    private AssignTask assignTask;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private EmployeeModel employeeModel;

    private LocalDate dueDate;
    private String observResult;
    private WorkOrderStatus workOrderStatus;
    private EquipStatus equipStatus;
    private LocalDate doneDate;

    public LocalDate getDoneDate() {
        return doneDate;
    }

    public void setDoneDate(LocalDate doneDate) {
        this.doneDate = doneDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AssignTask getAssignTask() {
        return assignTask;
    }

    public void setAssignTask(AssignTask assignTask) {
        this.assignTask = assignTask;
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public String getObservResult() {
        return observResult;
    }

    public void setObservResult(String observResult) {
        this.observResult = observResult;
    }

    public WorkOrderStatus getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(WorkOrderStatus workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }

    public EquipStatus getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(EquipStatus equipStatus) {
        this.equipStatus = equipStatus;
    }
}
