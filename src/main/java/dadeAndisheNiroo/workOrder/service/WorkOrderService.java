package dadeAndisheNiroo.workOrder.service;

import dadeAndisheNiroo.authentication.controller.UserController;
import dadeAndisheNiroo.employee.repository.EmployeeRepository;
import dadeAndisheNiroo.task.AssignTaskStatus;
import dadeAndisheNiroo.task.model.AssignTask;
import dadeAndisheNiroo.task.model.DefinedTask;
import dadeAndisheNiroo.task.repository.AssignedTaskRepository;
import dadeAndisheNiroo.workOrder.DTO.AssignWorkOrderDTO;
import dadeAndisheNiroo.workOrder.DTO.ObservationDTO;
import dadeAndisheNiroo.workOrder.WorkOrderResponse;
import dadeAndisheNiroo.workOrder.WorkOrderStatus;
import dadeAndisheNiroo.workOrder.model.WorkOrderModel;
import dadeAndisheNiroo.workOrder.repository.WorkOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

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

    public void generateWorkOrders() {

        List<AssignTask> tasks = assignedTaskRepository.findReadyTasks();
        System.out.println("tasks num="+ tasks.size());
        for (AssignTask task : tasks) {
            System.out.println("assigned task id="+ task.getId());
            DefinedTask definedTask = task.getDefinedTask();

//            LocalDate nextDueDate = null;
//            if (task.getLastExecutionDate() == null) {
//                if (definedTask.getStartDate().isBefore(LocalDate.now())) {
//                    nextDueDate = LocalDate.now();
//                } else
//                    nextDueDate = definedTask.getStartDate();
//            } else {
//                nextDueDate = task.getLastExecutionDate()
//                        .plusDays(definedTask.getPeriodDay());
//            }

//            if (nextDueDate.isBefore(LocalDate.now())
//                    || nextDueDate.isEqual(LocalDate.now())) {
//
//                boolean exists =
//                        workOrderRepository
//                                .existsByWorkOrderStatusAndAssignTask_Id(
//                                 List.of(WorkOrderStatus.InProgresstask.getId());
//
//                if (!exists) {
//                    System.out.println("generate for task"+ task.getId());
                    LocalDate nextDueDate = LocalDate.now()
                        .plusDays(definedTask.getPeriodDay());
                    addWorkOrder(task, nextDueDate);
                    assignedTaskRepository.updateAssignTaskStatus(definedTask.getId(), AssignTaskStatus.SENT);
//                }
            }

    }

    public void addWorkOrder(AssignTask task, LocalDate nextDueDate){
        WorkOrderModel wo= new WorkOrderModel();
        logger.info("create new work order through scheduled task");
        wo.setAssignTask(task);

//        EmployeeModel employeeModel= employeeRepository.findById(1)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));

//        wo.setEmployeeModel(employeeModel);
        wo.setDueDate(nextDueDate);
        wo.setWorkOrderStatus(WorkOrderStatus.New);

        workOrderRepository.save(wo);
    }

    public void addObservation(
            ObservationDTO observationDTO) {

        WorkOrderModel workOrder =
                workOrderRepository.findById(observationDTO.getWorkOrderId())
                        .orElseThrow(() ->
                                new RuntimeException("Work order not found"));

        // business validation
        if (workOrder.getWorkOrderStatus() == WorkOrderStatus.Done) {
            throw new RuntimeException(
                    "Observation already completed");
        }

        // save expert observation
        workOrder.setObservResult(observationDTO.getObservResult());

        // update status
        workOrder.setWorkOrderStatus(WorkOrderStatus.Done);
        workOrder.setEquipStatus(observationDTO.getEquipStatus());
        workOrder.setDoneDate(LocalDate.now());
        workOrderRepository.save(workOrder);
    }

    public List<WorkOrderResponse> getAllWorkOrders() {
        return workOrderRepository.findAll()
                .stream()
                .map(workOrder -> {
                    WorkOrderResponse response = new WorkOrderResponse();
                    response.setWorkOrderId(workOrder.getId());
                    response.setWorkOrderStatus(workOrder.getWorkOrderStatus());
                    response.setDueDate(workOrder.getDueDate());
                    response.setObservResult(workOrder.getObservResult());
                    response.setEquipmentName(workOrder.getAssignTask().getEquipModel().getName());
                    response.setEquipStatus(workOrder.getEquipStatus());
                    return response;
                })
                .toList();
    }

    public void assignWorkOrderToEmployee(AssignWorkOrderDTO assignWorkOrderDTO) {
        workOrderRepository.assignWorkOrderToEmployee(assignWorkOrderDTO.getEmployeeId(), assignWorkOrderDTO.getWorkOrderId());
    }
}
