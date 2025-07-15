package com.employee.department;

import com.employee.department.dto.DepartmentDTO;
import com.employee.department.model.Department;
import com.employee.department.repository.DepartmentRepository;
import com.employee.department.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    public void setup() {
        Department dept = new Department();
        dept.setId("dept03");
        dept.setName("Finance");
        dept.setLocation("B1");
        departmentRepository.save(dept);
    }

    @Test
    public void testGetAllDepartments() {
        List<DepartmentDTO> list = departmentService.getAll();
        assertFalse(list.isEmpty());
    }
}
