package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Region;

import com.cs499.a2.service.dto.RegionDTO;

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

public class RegionMapperImpl implements RegionMapper {

    @Override

    public RegionDTO regionToRegionDTO(Region region) {

        if ( region == null ) {

            return null;
        }

        RegionDTO regionDTO = new RegionDTO();

        regionDTO.setId( region.getId() );

        regionDTO.setRegionName( region.getRegionName() );

        return regionDTO;
    }

    @Override

    public List<RegionDTO> regionsToRegionDTOs(List<Region> regions) {

        if ( regions == null ) {

            return null;
        }

        List<RegionDTO> list = new ArrayList<RegionDTO>();

        for ( Region region : regions ) {

            list.add( regionToRegionDTO( region ) );
        }

        return list;
    }

    @Override

    public Region regionDTOToRegion(RegionDTO regionDTO) {

        if ( regionDTO == null ) {

            return null;
        }

        Region region = new Region();

        region.setId( regionDTO.getId() );

        region.setRegionName( regionDTO.getRegionName() );

        return region;
    }

    @Override

    public List<Region> regionDTOsToRegions(List<RegionDTO> regionDTOs) {

        if ( regionDTOs == null ) {

            return null;
        }

        List<Region> list = new ArrayList<Region>();

        for ( RegionDTO regionDTO : regionDTOs ) {

            list.add( regionDTOToRegion( regionDTO ) );
        }

        return list;
    }
}

