package dadeAndisheNiroo.workOrder;

import dadeAndisheNiroo.equipment.EquipStatus;

import java.time.LocalDate;

public class WorkOrderResponse {

    private int workOrderId;
    private String equipmentName;
    private WorkOrderStatus workOrderStatus;
    private LocalDate dueDate;
    private EquipStatus equipStatus;
    private String observResult;

    // getters setters


    public int getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public EquipStatus getEquipStatus() {
        return equipStatus;
    }

    public void setEquipStatus(EquipStatus equipStatus) {
        this.equipStatus = equipStatus;
    }

    public String getObservResult() {
        return observResult;
    }

    public void setObservResult(String observResult) {
        this.observResult = observResult;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public WorkOrderStatus getWorkOrderStatus() {
        return workOrderStatus;
    }

    public void setWorkOrderStatus(WorkOrderStatus workOrderStatus) {
        this.workOrderStatus = workOrderStatus;
    }
}