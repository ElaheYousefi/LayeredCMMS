package dadeAndisheNiroo.workOrder.repository;

import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOrderRepository extends JpaRepository<WorkOrderModel, Integer> {

    boolean existsByWorkOrderStatusAndAssignTask_Id(WorkOrderStatus workOrderStatus, int id);
}
