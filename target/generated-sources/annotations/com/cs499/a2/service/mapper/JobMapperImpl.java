package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Employee;

import com.cs499.a2.domain.Job;

import com.cs499.a2.domain.Task;

import com.cs499.a2.service.dto.JobDTO;

import com.cs499.a2.service.dto.TaskDTO;

import java.util.ArrayList;

import java.util.HashSet;

import java.util.List;

import java.util.Set;

import javax.annotation.Generated;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Generated(

    value = "org.mapstruct.ap.MappingProcessor",

    date = "2017-02-01T15:38:28-0800",

    comments = "version: 1.1.0.Final, compiler: javac, environment: Java 1.8.0_121 (Oracle Corporation)"

)

@Component

public class JobMapperImpl implements JobMapper {

    @Autowired

    private TaskMapper taskMapper;

    @Override

    public JobDTO jobToJobDTO(Job job) {

        if ( job == null ) {

            return null;
        }

        JobDTO jobDTO = new JobDTO();

        jobDTO.setEmployeeId( jobEmployeeId( job ) );

        jobDTO.setId( job.getId() );

        jobDTO.setJobTitle( job.getJobTitle() );

        jobDTO.setMinSalary( job.getMinSalary() );

        jobDTO.setMaxSalary( job.getMaxSalary() );

        Set<TaskDTO> set = taskSetToTaskDTOSet( job.getTasks() );

        if ( set != null ) {

            jobDTO.setTasks( set );
        }

        return jobDTO;
    }

    @Override

    public List<JobDTO> jobsToJobDTOs(List<Job> jobs) {

        if ( jobs == null ) {

            return null;
        }

        List<JobDTO> list = new ArrayList<JobDTO>();

        for ( Job job : jobs ) {

            list.add( jobToJobDTO( job ) );
        }

        return list;
    }

    @Override

    public Job jobDTOToJob(JobDTO jobDTO) {

        if ( jobDTO == null ) {

            return null;
        }

        Job job = new Job();

        job.setEmployee( employeeFromId( jobDTO.getEmployeeId() ) );

        job.setId( jobDTO.getId() );

        job.setJobTitle( jobDTO.getJobTitle() );

        job.setMinSalary( jobDTO.getMinSalary() );

        job.setMaxSalary( jobDTO.getMaxSalary() );

        Set<Task> set = taskDTOSetToTaskSet( jobDTO.getTasks() );

        if ( set != null ) {

            job.setTasks( set );
        }

        return job;
    }

    @Override

    public List<Job> jobDTOsToJobs(List<JobDTO> jobDTOs) {

        if ( jobDTOs == null ) {

            return null;
        }

        List<Job> list = new ArrayList<Job>();

        for ( JobDTO jobDTO : jobDTOs ) {

            list.add( jobDTOToJob( jobDTO ) );
        }

        return list;
    }

    private Long jobEmployeeId(Job job) {

        if ( job == null ) {

            return null;
        }

        Employee employee = job.getEmployee();

        if ( employee == null ) {

            return null;
        }

        Long id = employee.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }

    protected Set<TaskDTO> taskSetToTaskDTOSet(Set<Task> set) {

        if ( set == null ) {

            return null;
        }

        Set<TaskDTO> set_ = new HashSet<TaskDTO>();

        for ( Task task : set ) {

            set_.add( taskMapper.taskToTaskDTO( task ) );
        }

        return set_;
    }

    protected Set<Task> taskDTOSetToTaskSet(Set<TaskDTO> set) {

        if ( set == null ) {

            return null;
        }

        Set<Task> set_ = new HashSet<Task>();

        for ( TaskDTO taskDTO : set ) {

            set_.add( taskMapper.taskDTOToTask( taskDTO ) );
        }

        return set_;
    }
}

