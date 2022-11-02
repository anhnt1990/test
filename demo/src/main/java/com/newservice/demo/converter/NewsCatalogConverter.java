package com.newservice.demo.converter;

import com.newservice.demo.dto.NewsCatalogDto;
import com.newservice.demo.entity.NewsCatalog;
import org.springframework.stereotype.Component;

@Component
public class NewsCatalogConverter {

    public NewsCatalog toEntity (NewsCatalogDto dto){
        NewsCatalog entity = new NewsCatalog();
        entity.setCatalogName(dto.getCatalogName());
        entity.setCatalogHeader(dto.getCatalogHeader());
        entity.setWhoCreate(dto.getWhoCreate());
        entity.setDateCreate(dto.getDateCreate());
        entity.setNote(dto.getNote());
        return entity;
    }

    public NewsCatalog toEntity (NewsCatalogDto dto, NewsCatalog newsCatalogEntity){
        NewsCatalog entity = new NewsCatalog();
        entity.setCatalogName(dto.getCatalogName());
        entity.setCatalogHeader(dto.getCatalogHeader());
        entity.setWhoCreate(dto.getWhoCreate());
        entity.setDateCreate(dto.getDateCreate());
        entity.setNote(dto.getNote());
        return entity;
    }

    public NewsCatalogDto toDto(NewsCatalog entity){
        NewsCatalogDto dto = new NewsCatalogDto();
        if(entity.getId()!=null){
            dto.setId(entity.getId());
        }
        dto.setCatalogName(entity.getCatalogName());
        dto.setCatalogHeader(entity.getCatalogHeader());
        dto.setWhoCreate(entity.getWhoCreate());
        dto.setDateCreate(entity.getDateCreate());
        dto.setNote(entity.getNote());
        return dto;
    }
}
