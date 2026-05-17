package dadeAndisheNiroo.employee.controller;

import dadeAndisheNiroo.employee.model.EmployeeModel;
import dadeAndisheNiroo.employee.repository.EmployeeRepository;
import dadeAndisheNiroo.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmpolyeeController {

    EmployeeService employeeService;

    @Autowired
    public EmpolyeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    ResponseEntity<List<EmployeeModel>> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }
}
