package dadeAndisheNiroo.workOrder.service;

import dadeAndisheNiroo.task.model.AssignTask;
import dadeAndisheNiroo.task.repository.AssignedTaskRepository;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import dadeAndisheNiroo.workOrder.repository.WorkOrderRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class WorkOrderServiceTest {

    @Autowired
    private WorkOrderService workOrderService;

    @Autowired
    private WorkOrderRepository workOrderRepository;

    @Autowired
    private AssignedTaskRepository assignedTaskRepository;

    @Test
    void addWorkOrder() {

    }

    @Test
    void addObservation() {

        // arrange
        AssignTask task =
                assignedTaskRepository.findAll().get(0);

        WorkOrderModel workOrder = new WorkOrderModel();

        workOrder.setAssignTask(task);
        workOrder.setWorkOrderStatus(WorkOrderStatus.InProgress);

        WorkOrderModel saved =
                workOrderRepository.save(workOrder);

        // act
//        workOrderService.addObservation(
//                saved.getId(),
//                "Oil leakage checked",
//                WorkOrderStatus.Done
//        );

        // assert
        WorkOrderModel updated =
                workOrderRepository.findById(saved.getId())
                        .orElseThrow();

        assertEquals(
                "Oil leakage checked",
                updated.getObservResult());

        assertEquals(
                WorkOrderStatus.Done,
                updated.getWorkOrderStatus());

        }
}