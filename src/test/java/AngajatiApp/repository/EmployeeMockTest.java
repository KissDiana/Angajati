package AngajatiApp.repository;

import AngajatiApp.controller.DidacticFunction;
import AngajatiApp.model.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeMockTest {
    private EmployeeMock employeeRepository;

    @BeforeEach
    void setUp() {
        employeeRepository = new EmployeeMock();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void modifyEmployeeFunction() {
        try {
            Employee Mihai = new Employee("Ion", "Dumitrescu", "1234567790870", DidacticFunction.LECTURER, 2500d);
            employeeRepository.addEmployee(Mihai);
            employeeRepository.modifyEmployeeFunction(Mihai, DidacticFunction.TEACHER);
            assertEquals(DidacticFunction.TEACHER, Mihai.getFunction());
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    void modifyEmployeeFunction_Invalid() {
        try {
            Employee Mihai = new Employee("Ion", "Dumitrescu", "1234567790870", DidacticFunction.LECTURER, 2500d);
            employeeRepository.addEmployee(Mihai);
            employeeRepository.modifyEmployeeFunction(null, DidacticFunction.TEACHER);
            assert(true);
        } catch (Exception e) {
            assert (false);
        }
    }

    @Test
    void TC1_addEmployee() {
        try {

            employeeRepository.addEmployee(new Employee("Pop","Lavinia","1234568709123", DidacticFunction.ASISTENT,3678.00));
            List<Employee> employeeList = employeeRepository.getEmployeeList();

            assertEquals(7, employeeList.size());

        } catch (Exception e) {
            assert(true);
        }
    }


    @Test
    void TC3_addInvalidCNP() {
        try {
            employeeRepository.addEmployee(new Employee("Popescu","Maria","12345", DidacticFunction.ASISTENT,3678.00));

            List<Employee> employeeList = employeeRepository.getEmployeeList();

            assertEquals(6, employeeList.size());

        } catch (Exception e) {
            assert(true);
        }
    }

    @Test

    void TC7_addInvalidSalary(){

        try {
            employeeRepository.addEmployee(new Employee("Matei","Pop","5234568765345", DidacticFunction.ASISTENT,900.00));

            List<Employee> employeeList = employeeRepository.getEmployeeList();

            assertEquals(7, employeeList.size());

        } catch (Exception e) {
            assert(true);
        }
    }

    @Test
    void TC6_addGoodSalary(){
        try {

            employeeRepository.addEmployee(new Employee("Alina","Popescu","8234568765345", DidacticFunction.ASISTENT,1250.00));


            List<Employee> employeeList = employeeRepository.getEmployeeList();

            assertEquals(7, employeeList.size());
        } catch (Exception e) {
            assert(true);
        }
    }
}