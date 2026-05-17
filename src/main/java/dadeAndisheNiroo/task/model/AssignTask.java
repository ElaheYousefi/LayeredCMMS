package dadeAndisheNiroo.task.model;

import dadeAndisheNiroo.equipment.model.EquipModel;
import dadeAndisheNiroo.task.AssignTaskStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class AssignTask {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    @JoinColumn(name="equip_id")
    private EquipModel equipModel;

    @ManyToOne
    @JoinColumn(name="definedTask_id")
    private DefinedTask definedTask;

    private LocalDate nextExecutionDate;

    @OneToMany(mappedBy = "assignTask")
    private List<WorkOrderModel> workOrderModelList;

    @Nullable
    private Integer active;

    private AssignTaskStatus status;

    public AssignTaskStatus getStatus() {
        return status;
    }

    public void setStatus(AssignTaskStatus status) {
        this.status = status;
    }

    public LocalDate getNextExecutionDate() {
        return nextExecutionDate;
    }

    public void setNextExecutionDate(LocalDate nextExecutionDate) {
        this.nextExecutionDate = nextExecutionDate;
    }

    public void setActive(@Nullable Integer active) {
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EquipModel getEquipModel() {
        return equipModel;
    }

    public void setEquipModel(EquipModel equipModel) {
        this.equipModel = equipModel;
    }

    public DefinedTask getDefinedTask() {
        return definedTask;
    }

    public void setDefinedTask(DefinedTask definedTask) {
        this.definedTask = definedTask;
    }

    public List<WorkOrderModel> getWorkOrderModelList() {
        return workOrderModelList;
    }

    public void setWorkOrderModelList(List<WorkOrderModel> workOrderModelList) {
        this.workOrderModelList = workOrderModelList;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }
}
