package com.employee.department.controller;

import com.employee.department.dto.EmployeeDTO;
import com.employee.department.model.Employee;
import com.employee.department.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/department/{id}")
    public List<EmployeeDTO> getByDept(@PathVariable String id) {
        return service.getByDept(id);
    }

    @PostMapping("/department/{id}")
    public EmployeeDTO add(@PathVariable String id, @RequestBody Employee emp) {
        return service.add(id, emp);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
