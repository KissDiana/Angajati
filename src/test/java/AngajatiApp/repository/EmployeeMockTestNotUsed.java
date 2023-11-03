package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTestNotUsed {
    private Employee employee;
    private EmployeeMock employeeController;

    @BeforeEach
    void setUp() {
        EmployeeRepositoryInterface employeeRepository = new EmployeeImpl();
        EmployeeMock employeeController = new EmployeeMock();

    }

    @Test
    void TC1_addEmployee() {
        try {

            employeeController.addEmployee(new Employee("Pop","Lavinia","1234568709123", DidacticFunction.ASISTENT,3678.00));
            List<Employee> employeeList = employeeController.getEmployeeList();

            assertEquals(1, employeeList.size());

        } catch (Exception e) {
            assert(true);
        }
    }


    @Test
    void TC3_addInvalidCNP() {
        try {
            employeeController.addEmployee(new Employee("Popescu","Maria","12345", DidacticFunction.ASISTENT,3678.00));

            List<Employee> employeeList = employeeController.getEmployeeList();

            assertEquals(0, employeeList.size());

        } catch (Exception e) {
            assert(true);
        }
    }

    @Test

    void TC7_addInvalidSalary(){

        try {
            employeeController.addEmployee(new Employee("Matei","Pop","5234568765345", DidacticFunction.ASISTENT,900.00));

            List<Employee> employeeList = employeeController.getEmployeeList();

            assertEquals(0, employeeList.size());

    } catch (Exception e) {
        assert(true);
    }
    }

@Test
    void TC6_addGoodSalary(){
        try {

            employeeController.addEmployee(new Employee("Alina","Popescu","8234568765345", DidacticFunction.ASISTENT,1250.00));


            List<Employee> employeeList = employeeController.getEmployeeList();

            assertEquals(1, employeeList.size());
        } catch (Exception e) {
            assert(true);
        }
    }
}