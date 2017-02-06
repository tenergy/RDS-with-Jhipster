package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Department;

import com.cs499.a2.domain.Employee;

import com.cs499.a2.domain.Job;

import com.cs499.a2.domain.JobHistory;

import com.cs499.a2.service.dto.JobHistoryDTO;

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

public class JobHistoryMapperImpl implements JobHistoryMapper {

    @Override

    public JobHistoryDTO jobHistoryToJobHistoryDTO(JobHistory jobHistory) {

        if ( jobHistory == null ) {

            return null;
        }

        JobHistoryDTO jobHistoryDTO = new JobHistoryDTO();

        jobHistoryDTO.setJobId( jobHistoryJobId( jobHistory ) );

        jobHistoryDTO.setEmployeeId( jobHistoryEmployeeId( jobHistory ) );

        jobHistoryDTO.setDepartmentId( jobHistoryDepartmentId( jobHistory ) );

        jobHistoryDTO.setId( jobHistory.getId() );

        jobHistoryDTO.setStartDate( jobHistory.getStartDate() );

        jobHistoryDTO.setEndDate( jobHistory.getEndDate() );

        jobHistoryDTO.setLanguage( jobHistory.getLanguage() );

        return jobHistoryDTO;
    }

    @Override

    public List<JobHistoryDTO> jobHistoriesToJobHistoryDTOs(List<JobHistory> jobHistories) {

        if ( jobHistories == null ) {

            return null;
        }

        List<JobHistoryDTO> list = new ArrayList<JobHistoryDTO>();

        for ( JobHistory jobHistory : jobHistories ) {

            list.add( jobHistoryToJobHistoryDTO( jobHistory ) );
        }

        return list;
    }

    @Override

    public JobHistory jobHistoryDTOToJobHistory(JobHistoryDTO jobHistoryDTO) {

        if ( jobHistoryDTO == null ) {

            return null;
        }

        JobHistory jobHistory = new JobHistory();

        jobHistory.setJob( jobFromId( jobHistoryDTO.getJobId() ) );

        jobHistory.setDepartment( departmentFromId( jobHistoryDTO.getDepartmentId() ) );

        jobHistory.setEmployee( employeeFromId( jobHistoryDTO.getEmployeeId() ) );

        jobHistory.setId( jobHistoryDTO.getId() );

        jobHistory.setStartDate( jobHistoryDTO.getStartDate() );

        jobHistory.setEndDate( jobHistoryDTO.getEndDate() );

        jobHistory.setLanguage( jobHistoryDTO.getLanguage() );

        return jobHistory;
    }

    @Override

    public List<JobHistory> jobHistoryDTOsToJobHistories(List<JobHistoryDTO> jobHistoryDTOs) {

        if ( jobHistoryDTOs == null ) {

            return null;
        }

        List<JobHistory> list = new ArrayList<JobHistory>();

        for ( JobHistoryDTO jobHistoryDTO : jobHistoryDTOs ) {

            list.add( jobHistoryDTOToJobHistory( jobHistoryDTO ) );
        }

        return list;
    }

    private Long jobHistoryJobId(JobHistory jobHistory) {

        if ( jobHistory == null ) {

            return null;
        }

        Job job = jobHistory.getJob();

        if ( job == null ) {

            return null;
        }

        Long id = job.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }

    private Long jobHistoryEmployeeId(JobHistory jobHistory) {

        if ( jobHistory == null ) {

            return null;
        }

        Employee employee = jobHistory.getEmployee();

        if ( employee == null ) {

            return null;
        }

        Long id = employee.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }

    private Long jobHistoryDepartmentId(JobHistory jobHistory) {

        if ( jobHistory == null ) {

            return null;
        }

        Department department = jobHistory.getDepartment();

        if ( department == null ) {

            return null;
        }

        Long id = department.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

