package dadeAndisheNiroo.workOrder.controller;

import dadeAndisheNiroo.workOrder.DTO.AssignWorkOrderDTO;
import dadeAndisheNiroo.workOrder.DTO.ObservationDTO;
import dadeAndisheNiroo.workOrder.WorkOrderResponse;
import dadeAndisheNiroo.workOrder.service.WorkOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workOrders")
public class WorkOrderController {

    WorkOrderService workOrderService;

    @Autowired
    public WorkOrderController(WorkOrderService workOrderService) {
        this.workOrderService = workOrderService;
    }

    @GetMapping
    ResponseEntity<List<WorkOrderResponse>> getWorkOrders(){
        return ResponseEntity.ok(workOrderService.getAllWorkOrders());
    }

    @GetMapping("/assignWorkOrder")
    ResponseEntity<String> AssignWorkOrderToEmployee(@RequestBody AssignWorkOrderDTO assignWorkOrderDTO){
        try {
            workOrderService.assignWorkOrderToEmployee(assignWorkOrderDTO);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.ok("Error in assigning task");
        }
        return ResponseEntity.ok("Assigning task was successful");
    }

    @PostMapping("/addObservation")
    public String addObservationByEmployee(@RequestBody ObservationDTO observationDTO){
       try {
           workOrderService.addObservation(observationDTO);
       }catch (Exception e){
           return "Error in saving result";
       }
       return "Saving observation result was successful";
    }
}
