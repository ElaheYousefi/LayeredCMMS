//package dadeAndisheNiroo;
//
//import dadeAndisheNiroo.workOrder.repository.WorkOrderRepository;
//import dadeAndisheNiroo.workOrder.service.WorkOrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class DemoDataInitializer implements ApplicationRunner {
//
//    private WorkOrderRepository workOrderRepository;
//    private WorkOrderService workOrderService;
//
//    @Autowired
//    public DemoDataInitializer(WorkOrderRepository workOrderRepository, WorkOrderService workOrderService) {
//        this.workOrderRepository= workOrderRepository;
//        this.workOrderService= workOrderService;
//    }
//
//    @Override
//    public void run(ApplicationArguments args) {
//        // avoid duplicate demo data
//        if (workOrderRepository.count() > 0) {
//            return;
//        }
//        workOrderService.generateWorkOrders();
//        System.out.println("Demo work orders created.");
//    }
//}