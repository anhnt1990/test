package com.newservice.demo.service.interfaces;

import com.newservice.demo.dto.NewsCatalogDto;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface NewsCatalogService {
    List<NewsCatalogDto> findAll(Pageable pageable);

    NewsCatalogDto findByid(Integer id);

    long count();

    NewsCatalogDto save(NewsCatalogDto AccountDto);

    void delete(Integer id);

    Integer getNewId();
}
