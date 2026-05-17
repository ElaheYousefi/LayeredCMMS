package dadeAndisheNiroo.workOrder.DTO;

import dadeAndisheNiroo.equipment.EquipStatus;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;

public class ObservationDTO {

    private int workOrderId;
    private String observResult;
    private WorkOrderStatus workOrderStatus;
    private EquipStatus equipStatus;
//    doneDate;


    public ObservationDTO(int workOrderId, String observResult, WorkOrderStatus workOrderStatus, EquipStatus equipStatus) {
        this.workOrderId = workOrderId;
        this.observResult = observResult;
        this.workOrderStatus = workOrderStatus;
        this.equipStatus = equipStatus;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
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
