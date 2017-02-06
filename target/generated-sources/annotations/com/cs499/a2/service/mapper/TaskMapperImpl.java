package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Task;

import com.cs499.a2.service.dto.TaskDTO;

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

public class TaskMapperImpl implements TaskMapper {

    @Override

    public TaskDTO taskToTaskDTO(Task task) {

        if ( task == null ) {

            return null;
        }

        TaskDTO taskDTO = new TaskDTO();

        taskDTO.setId( task.getId() );

        taskDTO.setTitle( task.getTitle() );

        taskDTO.setDescription( task.getDescription() );

        return taskDTO;
    }

    @Override

    public List<TaskDTO> tasksToTaskDTOs(List<Task> tasks) {

        if ( tasks == null ) {

            return null;
        }

        List<TaskDTO> list = new ArrayList<TaskDTO>();

        for ( Task task : tasks ) {

            list.add( taskToTaskDTO( task ) );
        }

        return list;
    }

    @Override

    public Task taskDTOToTask(TaskDTO taskDTO) {

        if ( taskDTO == null ) {

            return null;
        }

        Task task = new Task();

        task.setId( taskDTO.getId() );

        task.setTitle( taskDTO.getTitle() );

        task.setDescription( taskDTO.getDescription() );

        return task;
    }

    @Override

    public List<Task> taskDTOsToTasks(List<TaskDTO> taskDTOs) {

        if ( taskDTOs == null ) {

            return null;
        }

        List<Task> list = new ArrayList<Task>();

        for ( TaskDTO taskDTO : taskDTOs ) {

            list.add( taskDTOToTask( taskDTO ) );
        }

        return list;
    }
}

