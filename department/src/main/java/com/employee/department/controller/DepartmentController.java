package com.employee.department.controller;

import com.employee.department.dto.DepartmentDTO;
import com.employee.department.model.Department;
import com.employee.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;

    @GetMapping
    public List<DepartmentDTO> getAll() {
        return service.getAll();
    }
}
