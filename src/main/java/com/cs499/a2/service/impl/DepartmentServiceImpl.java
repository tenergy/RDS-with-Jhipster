package com.cs499.a2.service.impl;

import com.cs499.a2.service.DepartmentService;
import com.cs499.a2.domain.Department;
import com.cs499.a2.repository.DepartmentRepository;
import com.cs499.a2.service.dto.DepartmentDTO;
import com.cs499.a2.service.mapper.DepartmentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Department.
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService{

    private final Logger log = LoggerFactory.getLogger(DepartmentServiceImpl.class);
    
    @Inject
    private DepartmentRepository departmentRepository;

    @Inject
    private DepartmentMapper departmentMapper;

    /**
     * Save a department.
     *
     * @param departmentDTO the entity to save
     * @return the persisted entity
     */
    public DepartmentDTO save(DepartmentDTO departmentDTO) {
        log.debug("Request to save Department : {}", departmentDTO);
        Department department = departmentMapper.departmentDTOToDepartment(departmentDTO);
        department = departmentRepository.save(department);
        DepartmentDTO result = departmentMapper.departmentToDepartmentDTO(department);
        return result;
    }

    /**
     *  Get all the departments.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<DepartmentDTO> findAll() {
        log.debug("Request to get all Departments");
        List<DepartmentDTO> result = departmentRepository.findAll().stream()
            .map(departmentMapper::departmentToDepartmentDTO)
            .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }

    /**
     *  Get one department by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public DepartmentDTO findOne(Long id) {
        log.debug("Request to get Department : {}", id);
        Department department = departmentRepository.findOne(id);
        DepartmentDTO departmentDTO = departmentMapper.departmentToDepartmentDTO(department);
        return departmentDTO;
    }

    /**
     *  Delete the  department by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Department : {}", id);
        departmentRepository.delete(id);
    }
}
