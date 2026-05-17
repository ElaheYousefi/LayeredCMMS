package dadeAndisheNiroo.employee.service;

import dadeAndisheNiroo.employee.model.EmployeeModel;
import dadeAndisheNiroo.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeModel> getEmployees(){
        return employeeRepository.findAll();
    }
}
