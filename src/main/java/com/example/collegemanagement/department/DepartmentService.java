package com.example.collegemanagement.department;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Optional<Department> getDepartmentById(Long id) {
        return Optional.ofNullable(departmentRepository.findById(id).
                orElseThrow(() -> new DepartmentNotFoundException("Department with id: " + id + " not found.")));
    }
    public Optional<Department> getDepartmentByName(String name) {
        return Optional.ofNullable(departmentRepository.findByName(name).
                orElseThrow(() -> new DepartmentNotFoundException("Department with name: " + name + " not found.")));
    }
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
    public Department updateDepartment(Department department) {
        Optional<Department> existingDepartment = departmentRepository.findById(department.getId());
        if (existingDepartment.isPresent()) {
            return departmentRepository.save(department);
        }
        return department;
    }
}
