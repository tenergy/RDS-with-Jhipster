package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Department;

import com.cs499.a2.domain.Employee;

import com.cs499.a2.service.dto.EmployeeDTO;

import java.util.ArrayList;

import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-02-01T15:38:28-0800",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"

)

@Component

public class EmployeeMapperImpl implements EmployeeMapper {

    @Override

    public EmployeeDTO employeeToEmployeeDTO(Employee employee) {

        if ( employee == null ) {

            return null;
        }

        EmployeeDTO employeeDTO = new EmployeeDTO();

        employeeDTO.setDepartmentId( employeeDepartmentId( employee ) );

        employeeDTO.setManagerId( employeeManagerId( employee ) );

        employeeDTO.setId( employee.getId() );

        employeeDTO.setFirstName( employee.getFirstName() );

        employeeDTO.setLastName( employee.getLastName() );

        employeeDTO.setEmail( employee.getEmail() );

        employeeDTO.setPhoneNumber( employee.getPhoneNumber() );

        employeeDTO.setHireDate( employee.getHireDate() );

        employeeDTO.setSalary( employee.getSalary() );

        employeeDTO.setCommissionPct( employee.getCommissionPct() );

        return employeeDTO;
    }

    @Override

    public List<EmployeeDTO> employeesToEmployeeDTOs(List<Employee> employees) {

        if ( employees == null ) {

            return null;
        }

        List<EmployeeDTO> list = new ArrayList<EmployeeDTO>();

        for ( Employee employee : employees ) {

            list.add( employeeToEmployeeDTO( employee ) );
        }

        return list;
    }

    @Override

    public Employee employeeDTOToEmployee(EmployeeDTO employeeDTO) {

        if ( employeeDTO == null ) {

            return null;
        }

        Employee employee = new Employee();

        employee.setManager( employeeFromId( employeeDTO.getManagerId() ) );

        employee.setDepartment( departmentFromId( employeeDTO.getDepartmentId() ) );

        employee.setId( employeeDTO.getId() );

        employee.setFirstName( employeeDTO.getFirstName() );

        employee.setLastName( employeeDTO.getLastName() );

        employee.setEmail( employeeDTO.getEmail() );

        employee.setPhoneNumber( employeeDTO.getPhoneNumber() );

        employee.setHireDate( employeeDTO.getHireDate() );

        employee.setSalary( employeeDTO.getSalary() );

        employee.setCommissionPct( employeeDTO.getCommissionPct() );

        return employee;
    }

    @Override

    public List<Employee> employeeDTOsToEmployees(List<EmployeeDTO> employeeDTOs) {

        if ( employeeDTOs == null ) {

            return null;
        }

        List<Employee> list = new ArrayList<Employee>();

        for ( EmployeeDTO employeeDTO : employeeDTOs ) {

            list.add( employeeDTOToEmployee( employeeDTO ) );
        }

        return list;
    }

    private Long employeeDepartmentId(Employee employee) {

        if ( employee == null ) {

            return null;
        }

        Department department = employee.getDepartment();

        if ( department == null ) {

            return null;
        }

        Long id = department.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }

    private Long employeeManagerId(Employee employee) {

        if ( employee == null ) {

            return null;
        }

        Employee manager = employee.getManager();

        if ( manager == null ) {

            return null;
        }

        Long id = manager.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

