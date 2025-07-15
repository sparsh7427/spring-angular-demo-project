package com.employee.department;

import com.employee.department.dto.EmployeeDTO;
import com.employee.department.model.Department;
import com.employee.department.model.Employee;
import com.employee.department.repository.DepartmentRepository;
import com.employee.department.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    public void setup() {
        Department dept = new Department();
        dept.setId("dept03");
        dept.setName("HR");
        dept.setLocation("A1");
        departmentRepository.save(dept);
    }

    @Test
    public void testAddEmployeeToDepartment() {
        Employee emp = new Employee();
        emp.setId("emp01");
        emp.setName("Test User");
        emp.setEmail("test@example.com");
        emp.setPosition("Analyst");
        emp.setSalary(50000);

        EmployeeDTO saved = employeeService.add("dept03", emp);
        assertNotNull(saved);
        assertEquals("Test User", saved.getName());
        assertNotNull(saved.getDepartment());
        assertEquals("dept03", saved.getDepartment().getId());
    }

    @Test
    public void testGetByDept() {
        List<EmployeeDTO> emps = employeeService.getByDept("dept03");
        assertNotNull(emps);
    }
}
