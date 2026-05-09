package dadeAndisheNiroo.workOrder.service;

import dadeAndisheNiroo.authentication.controller.UserController;
import dadeAndisheNiroo.employee.model.EmployeeModel;
import dadeAndisheNiroo.employee.repository.EmployeeRepository;
import dadeAndisheNiroo.task.model.AssignTask;
import dadeAndisheNiroo.task.model.DefinedTask;
import dadeAndisheNiroo.task.repository.AssignedTaskRepository;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import dadeAndisheNiroo.workOrder.repository.WorkOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;

@Service
@Transactional
public class WorkOrderService {

    private WorkOrderRepository workOrderRepository;
    private AssignedTaskRepository assignedTaskRepository;
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);
    private EmployeeRepository employeeRepository;

    @Autowired
    public WorkOrderService(WorkOrderRepository workOrderRepository, AssignedTaskRepository assignedTaskRepository, EmployeeRepository employeeRepository) {
        this.workOrderRepository= workOrderRepository;
        this.assignedTaskRepository= assignedTaskRepository;
        this.employeeRepository= employeeRepository;
    }

    public void addWorkOrder(AssignTask task, LocalDate nextDueDate){
        WorkOrderModel wo= new WorkOrderModel();
        logger.info("create new work order through scheduled task");
        wo.setAssignTask(task);

        EmployeeModel employeeModel= employeeRepository.findById(1)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        wo.setEmployeeModel(employeeModel);
        wo.setDueDate(nextDueDate);
        wo.setWorkOrderStatus(WorkOrderStatus.InProgress);

        workOrderRepository.save(wo);
    }

    public void addObservation(
            Integer workOrderId,
            String observation,
            WorkOrderStatus status) {

        WorkOrderModel workOrder =
                workOrderRepository.findById(workOrderId)
                        .orElseThrow(() ->
                                new RuntimeException("Work order not found"));

        // business validation
        if (workOrder.getWorkOrderStatus() == WorkOrderStatus.Done) {
            throw new RuntimeException(
                    "Observation already completed");
        }

        // save expert observation
        workOrder.setObservResult(observation);

        // update status
        workOrder.setWorkOrderStatus(status);

        // if completed update execution date
        if (status == WorkOrderStatus.Done) {

            AssignTask assignTask =
                    workOrder.getAssignTask();

            DefinedTask definedTask =
                    assignTask.getDefinedTask();

            assignTask.setLastExecutionDate(LocalDate.now());
        }

        workOrderRepository.save(workOrder);
    }
}
