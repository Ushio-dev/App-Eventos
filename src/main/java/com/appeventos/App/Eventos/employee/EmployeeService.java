package com.appeventos.App.Eventos.employee;

import com.appeventos.App.Eventos.customexceptions.NotFoundEmployee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee findOneEmployee(Long id) throws NotFoundEmployee;
    void save(EmployeeRequest employeeRequest);
    void update(Employee employee);
    void deleteById(Long id);
}
