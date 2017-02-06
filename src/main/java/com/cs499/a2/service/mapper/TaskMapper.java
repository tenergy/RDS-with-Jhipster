package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.*;
import com.cs499.a2.service.dto.TaskDTO;

import org.mapstruct.*;
import java.util.List;

/**
 * Mapper for the entity Task and its DTO TaskDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface TaskMapper {

    TaskDTO taskToTaskDTO(Task task);

    List<TaskDTO> tasksToTaskDTOs(List<Task> tasks);

    @Mapping(target = "jobs", ignore = true)
    Task taskDTOToTask(TaskDTO taskDTO);

    List<Task> taskDTOsToTasks(List<TaskDTO> taskDTOs);
}
