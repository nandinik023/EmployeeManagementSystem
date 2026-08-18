package com.jfs.example.dao;

import com.jfs.example.bean.Employee;
import org.junit.jupiter.api.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDAOTest {
    private EmployeeDAO employeeDAO;

    @BeforeEach
    void setUp() {
        employeeDAO = new EmployeeDAO();
        // Reset static map for isolation
        EmployeeDAO.mapOfEmloyees.clear();
        EmployeeDAO.mapOfEmloyees.put(10001, new Employee("Jack",10001,12345.6,1001));
        EmployeeDAO.mapOfEmloyees.put(10002, new Employee("Justin",10002,12355.6,1002));
        EmployeeDAO.mapOfEmloyees.put(10003, new Employee("Eric",10003,12445.6,1003));
    }

    @Test
    void testGetAllEmployee() {
        Collection<Employee> employees = employeeDAO.getAllEmployee();
        assertEquals(3, employees.size());
    }

    @Test
    void testGetEmployeeDetailsById() {
        Employee emp = employeeDAO.getEmployeeDetailsById(10001);
        assertNotNull(emp);
        assertEquals("Jack", emp.getEmployeeName());
    }

    @Test
    void testAddEmployee() {
        Employee newEmp = new Employee("Alice", null, 13000.0, 1004);
        Integer id = employeeDAO.addEmployee(newEmp);
        assertNotNull(id);
        assertEquals(newEmp, employeeDAO.getEmployeeDetailsById(id));
    }

    @Test
    void testUpdateEmployee() {
        Employee emp = new Employee("JackUpdated", 10001, 15000.0, 1001);
        Employee updated = employeeDAO.updateEmployee(emp);
        assertEquals("JackUpdated", updated.getEmployeeName());
        assertEquals(15000.0, updated.getSalary());
    }

    @Test
    void testRemoveEmployee() {
        Employee removed = employeeDAO.removeEmployee(10002);
        assertNotNull(removed);
        assertNull(employeeDAO.getEmployeeDetailsById(10002));
    }
}
