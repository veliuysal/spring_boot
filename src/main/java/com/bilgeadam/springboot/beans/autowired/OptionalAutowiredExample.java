package com.bilgeadam.springboot.beans.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OptionalAutowiredExample {

    private final EmployeeService employeeService;
    private ManagerService managerService;

    @Autowired(required = false)
    private OrderService orderService;


    @Autowired
    public OptionalAutowiredExample(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Autowired(required = false)
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }
}
