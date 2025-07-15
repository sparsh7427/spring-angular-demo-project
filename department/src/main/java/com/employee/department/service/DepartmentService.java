package com.employee.department.service;

import com.employee.department.dto.DepartmentDTO;
import com.employee.department.model.Department;
import com.employee.department.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository repo;

    public List<DepartmentDTO> getAll() {

        return repo.findAll().stream().map(dept -> {
            DepartmentDTO dto = new DepartmentDTO();
            dto.setId(dept.getId());
            dto.setName(dept.getName());
            dto.setLocation(dept.getLocation());
            return dto;
        }).collect(Collectors.toList());
    }
}
