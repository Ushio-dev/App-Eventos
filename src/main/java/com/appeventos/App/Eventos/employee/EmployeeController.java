package com.appeventos.App.Eventos.employee;

import com.appeventos.App.Eventos.customexceptions.NotFoundEmployee;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {
        try {
            return ResponseEntity.ok(employeeService.getAllEmployees());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findOneEmployee(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(employeeService.findOneEmployee(id));
        }catch (NotFoundEmployee e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<?> createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try {
            employeeService.save(employeeRequest);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
        try {
            employeeService.update(employee);
            return ResponseEntity.accepted().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
