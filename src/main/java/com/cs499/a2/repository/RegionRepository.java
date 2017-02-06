package com.cs499.a2.repository;

import com.cs499.a2.domain.Region;

import org.springframework.data.jpa.repository.*;

import java.util.List;

/**
 * Spring Data JPA repository for the Region entity.
 */
@SuppressWarnings("unused")
public interface RegionRepository extends JpaRepository<Region,Long> {

}
