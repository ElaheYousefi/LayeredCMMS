package dadeAndisheNiroo.task.service;

import dadeAndisheNiroo.authentication.controller.UserController;
import dadeAndisheNiroo.employee.model.EmployeeModel;
import dadeAndisheNiroo.employee.repository.EmployeeRepository;
import dadeAndisheNiroo.task.model.AssignTask;
import dadeAndisheNiroo.task.model.DefinedTask;
import dadeAndisheNiroo.task.repository.AssignedTaskRepository;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import dadeAndisheNiroo.workOrder.repository.WorkOrderRepository;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.service.WorkOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class ScheduledTask {

    private AssignedTaskRepository assignedTaskRepository;
    private WorkOrderRepository workOrderRepository;
    private EmployeeRepository employeeRepository;
    private WorkOrderService workOrderService;
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    public ScheduledTask(AssignedTaskRepository assignedTaskRepository,
                         WorkOrderRepository workOrderRepository, EmployeeRepository employeeRepository,
                         WorkOrderService workOrderService) {
        this.assignedTaskRepository = assignedTaskRepository;
        this.workOrderRepository = workOrderRepository;
        this.employeeRepository = employeeRepository;
        this.workOrderService= workOrderService;
    }

    //    @Scheduled(cron = "0 0 1 * * *")
    // second min hour day month year
    // 0 means at second 0
    // 0 means at min 0
    // 1 means at 1 AM
    // means every day month year
    @Scheduled(fixedRate = 200000)  //each 200 seconds
    public void generateWorkOrdersScheduler() {
        logger.info("start scheduled task");
        workOrderService.generateWorkOrders();
    }
}
