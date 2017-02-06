package com.cs499.a2.service.mapper;

import com.cs499.a2.domain.Country;

import com.cs499.a2.domain.Region;

import com.cs499.a2.service.dto.CountryDTO;

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

public class CountryMapperImpl implements CountryMapper {

    @Override

    public CountryDTO countryToCountryDTO(Country country) {

        if ( country == null ) {

            return null;
        }

        CountryDTO countryDTO = new CountryDTO();

        countryDTO.setRegionId( countryRegionId( country ) );

        countryDTO.setId( country.getId() );

        countryDTO.setCountryName( country.getCountryName() );

        return countryDTO;
    }

    @Override

    public List<CountryDTO> countriesToCountryDTOs(List<Country> countries) {

        if ( countries == null ) {

            return null;
        }

        List<CountryDTO> list = new ArrayList<CountryDTO>();

        for ( Country country : countries ) {

            list.add( countryToCountryDTO( country ) );
        }

        return list;
    }

    @Override

    public Country countryDTOToCountry(CountryDTO countryDTO) {

        if ( countryDTO == null ) {

            return null;
        }

        Country country = new Country();

        country.setRegion( regionFromId( countryDTO.getRegionId() ) );

        country.setId( countryDTO.getId() );

        country.setCountryName( countryDTO.getCountryName() );

        return country;
    }

    @Override

    public List<Country> countryDTOsToCountries(List<CountryDTO> countryDTOs) {

        if ( countryDTOs == null ) {

            return null;
        }

        List<Country> list = new ArrayList<Country>();

        for ( CountryDTO countryDTO : countryDTOs ) {

            list.add( countryDTOToCountry( countryDTO ) );
        }

        return list;
    }

    private Long countryRegionId(Country country) {

        if ( country == null ) {

            return null;
        }

        Region region = country.getRegion();

        if ( region == null ) {

            return null;
        }

        Long id = region.getId();

        if ( id == null ) {

            return null;
        }

        return id;
    }
}

