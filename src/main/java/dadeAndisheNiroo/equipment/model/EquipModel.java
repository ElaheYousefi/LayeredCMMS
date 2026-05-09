package dadeAndisheNiroo.equipment.model;

import dadeAndisheNiroo.task.model.AssignTask;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="equipment")
public class EquipModel {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToMany(mappedBy = "equipModel")
    private List<AssignTask> assignTask;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AssignTask> getAssignTask() {
        return assignTask;
    }

    public void setAssignTask(List<AssignTask> assignTask) {
        this.assignTask = assignTask;
    }
}
