package com.appeventos.App.Eventos.employee;

import com.appeventos.App.Eventos.customexceptions.NotFoundEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findOneEmployee(Long id) throws NotFoundEmployee {
        Optional<Employee> oEmployee = employeeRepository.findById(id);

        if (oEmployee.isEmpty())
            throw new NotFoundEmployee("Employee does not exist");

        Employee employee = Employee.builder()
                .id(oEmployee.get().getId())
                .name(oEmployee.get().getName())
                .lastName(oEmployee.get().getLastName())
                .isActive(oEmployee.get().isActive())
                .fileNumber(oEmployee.get().getFileNumber())
                .build();

        return employee;
    }

    @Override
    public void save(EmployeeRequest employeeRequest) {
        Employee employee = Employee.builder()
                .name(employeeRequest.getName())
                .lastName(employeeRequest.getLastName())
                .fileNumber(employeeRequest.getFileNumber())
                .isActive(true)
                .build();
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeRepository.deleteById(id);
    }
}
