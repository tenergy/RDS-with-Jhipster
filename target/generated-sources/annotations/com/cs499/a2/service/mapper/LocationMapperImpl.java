package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Country;

import com.cs499.a2.domain.Location;

import com.cs499.a2.service.dto.LocationDTO;

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

public class LocationMapperImpl implements LocationMapper {

    @Override

    public LocationDTO locationToLocationDTO(Location location) {

        if ( location == null ) {

            return null;
        }

        LocationDTO locationDTO = new LocationDTO();

        locationDTO.setCountryId( locationCountryId( location ) );

        locationDTO.setId( location.getId() );

        locationDTO.setStreetAddress( location.getStreetAddress() );

        locationDTO.setPostalCode( location.getPostalCode() );

        locationDTO.setCity( location.getCity() );

        locationDTO.setStateProvince( location.getStateProvince() );

        return locationDTO;
    }

    @Override

    public List<LocationDTO> locationsToLocationDTOs(List<Location> locations) {

        if ( locations == null ) {

            return null;
        }

        List<LocationDTO> list = new ArrayList<LocationDTO>();

        for ( Location location : locations ) {

            list.add( locationToLocationDTO( location ) );
        }

        return list;
    }

    @Override

    public Location locationDTOToLocation(LocationDTO locationDTO) {

        if ( locationDTO == null ) {

            return null;
        }

        Location location = new Location();

        location.setCountry( countryFromId( locationDTO.getCountryId() ) );

        location.setId( locationDTO.getId() );

        location.setStreetAddress( locationDTO.getStreetAddress() );

        location.setPostalCode( locationDTO.getPostalCode() );

        location.setCity( locationDTO.getCity() );

        location.setStateProvince( locationDTO.getStateProvince() );

        return location;
    }

    @Override

    public List<Location> locationDTOsToLocations(List<LocationDTO> locationDTOs) {

        if ( locationDTOs == null ) {

            return null;
        }

        List<Location> list = new ArrayList<Location>();

        for ( LocationDTO locationDTO : locationDTOs ) {

            list.add( locationDTOToLocation( locationDTO ) );
        }

        return list;
    }

    private Long locationCountryId(Location location) {

        if ( location == null ) {

            return null;
        }

        Country country = location.getCountry();

        if ( country == null ) {

            return null;
        }

        Long id = country.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

