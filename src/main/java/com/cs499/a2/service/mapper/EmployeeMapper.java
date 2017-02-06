package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.*;
import com.cs499.a2.service.dto.EmployeeDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Employee and its DTO EmployeeDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface EmployeeMapper {

    @Mapping(source = "department.id", target = "departmentId")
    @Mapping(source = "manager.id", target = "managerId")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    List<EmployeeDTO> employeesToEmployeeDTOs(List<Employee> employees);

    @Mapping(source = "departmentId", target = "department")
    @Mapping(target = "jobs", ignore = true)
    @Mapping(source = "managerId", target = "manager")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

    List<Employee> employeeDTOsToEmployees(List<EmployeeDTO> employeeDTOs);

    default Department departmentFromId(Long id) {
        if (id == null) {
            return null;
        }
        Department department = new Department();
        department.setId(id);
        return department;
    }

    default Employee employeeFromId(Long id) {
        if (id == null) {
            return null;
        }
        Employee employee = new Employee();
        employee.setId(id);
        return employee;
    }
}
