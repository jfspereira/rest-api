package com.cofco.business.mapper;

import com.cofco.business.mapper.base.Mapper;
import org.springframework.stereotype.Component;
import com.cofco.business.dto.CompanyDto;
import com.cofco.data.entity.Company;


/**
 * Created by Tiago Vilas Boas on 16/06/2018.
 * Company to CompanyDto mapper
 */
@Component
public class CompanyMapper implements Mapper<Company, CompanyDto>{

    @Override
    public Company mapFrom(CompanyDto dto) {
        return dto == null ? null : (Company) new Company()
                .setName(dto.getName())
                .setAddress(dto.getAddress())
                .setCity(dto.getCity())
                .setCountry(dto.getCountry())
                .setEmail(dto.getEmail())
                .setPhoneNumber(dto.getPhoneNumber());
    }

    @Override
    public CompanyDto mapTo(Company entity) {
        return entity == null ? null : (CompanyDto) new CompanyDto()
                .setName(entity.getName())
                .setAddress(entity.getAddress())
                .setCity(entity.getCity())
                .setCountry(entity.getCountry())
                .setEmail(entity.getEmail())
                .setPhoneNumber(entity.getPhoneNumber())
                .setId(entity.getId());
    }

    @Override
    public CompanyDto map(CompanyDto dto, Company entity) {
        return entity == null ? null :
            dto == null ? null:
                (CompanyDto) new CompanyDto()
                    .setName(entity.getName())
                    .setAddress(entity.getAddress())
                    .setCity(entity.getCity())
                    .setCountry(entity.getCountry())
                    .setEmail(entity.getEmail())
                    .setPhoneNumber(entity.getPhoneNumber())
                    .setId(entity.getId());
    }
}
