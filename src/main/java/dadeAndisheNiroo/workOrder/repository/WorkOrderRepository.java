package dadeAndisheNiroo.workOrder.repository;

import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WorkOrderRepository extends JpaRepository<WorkOrderModel, Integer> {

    @Transactional
    @Modifying
    @Query("update WorkOrderModel w set w.employeeModel.id= ?1 where w.id= ?2")
    void assignWorkOrderToEmployee(int employeeId, int workOrderId);

//    boolean existsByWorkOrderStatusAndAssignTask_Id(List<WorkOrderStatus> workOrderStatus, int id);
}
