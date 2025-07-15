package com.employee.department.service;

import com.employee.department.dto.DepartmentDTO;
import com.employee.department.dto.EmployeeDTO;
import com.employee.department.model.Department;
import com.employee.department.model.Employee;
import com.employee.department.repository.DepartmentRepository;
import com.employee.department.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository empRepo;
    @Autowired
    private DepartmentRepository deptRepo;

    public List<EmployeeDTO> getAll() {
        return empRepo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<EmployeeDTO> getByDept(String deptId) {
        Department dept = deptRepo.findById(deptId).orElseThrow();
        return dept.getEmployees().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Transactional
    public EmployeeDTO add(String deptId, Employee emp) {
        Department dept = deptRepo.findById(deptId).orElseThrow();
        emp.setDepartment(dept);
        Employee saved = empRepo.save(emp);
        return mapToDTO(saved);
    }

    public void delete(String id) {
        empRepo.deleteById(id);
    }

    private EmployeeDTO mapToDTO(Employee emp) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(emp.getId());
        dto.setName(emp.getName());
        dto.setEmail(emp.getEmail());
        dto.setPosition(emp.getPosition());
        dto.setSalary(emp.getSalary());

        if (emp.getDepartment() != null) {
            DepartmentDTO deptDTO = new DepartmentDTO();
            deptDTO.setId(emp.getDepartment().getId());
            deptDTO.setName(emp.getDepartment().getName());
            deptDTO.setLocation(emp.getDepartment().getLocation());
            dto.setDepartment(deptDTO);
        }
        return dto;
    }
}
