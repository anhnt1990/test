package com.newservice.demo.service.impl;

import com.newservice.demo.converter.NewsCatalogConverter;
import com.newservice.demo.dto.NewsCatalogDto;
import com.newservice.demo.entity.NewsCatalog;
import com.newservice.demo.repository.NewCatalogRepo;
import com.newservice.demo.service.interfaces.NewsCatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsCatalogServiceImpl implements NewsCatalogService {

    @Autowired
    private NewCatalogRepo newCatalogRepo;

    @Autowired
    private NewsCatalogConverter newsCatalogConverter;

    @Autowired
    RestTemplate restTemplate;

    public NewsCatalog getByIdThrowException(Integer id){
        return newCatalogRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Account not exist with id:\" + id"));
    }



    @Override
    public List<NewsCatalogDto> findAll(Pageable pageable) {
        List<NewsCatalogDto> resuilts = new ArrayList<>();
        List<NewsCatalog> Entities = newCatalogRepo.findAll(pageable).getContent();
        for(NewsCatalog item:Entities){
            NewsCatalogDto newsCatalogDto = newsCatalogConverter.toDto(item);
            resuilts.add(newsCatalogDto);
        }
        return resuilts;
    }

    @Override
    public NewsCatalogDto findByid(Integer id) {
        NewsCatalog newsCatalogEntity = getByIdThrowException(id);
        return newsCatalogConverter.toDto(newsCatalogEntity);
    }

    @Override
    public long count() {
        return newCatalogRepo.count();
    }

    @Override
    public NewsCatalogDto save(NewsCatalogDto catalogDto) {
        NewsCatalog newsCatalogEntity;
        if(catalogDto.getId()==null){
            newsCatalogEntity = newsCatalogConverter.toEntity(catalogDto);
            newsCatalogEntity.setId(getNewId());
            newsCatalogEntity=postCatalogToPublicDB(newsCatalogEntity);
        }else{
            newsCatalogEntity = getByIdThrowException(catalogDto.getId());
            newsCatalogEntity = newsCatalogConverter.toEntity(catalogDto,newsCatalogEntity);
            newsCatalogEntity.setId(catalogDto.getId());
        }
        newsCatalogEntity = newCatalogRepo.save(newsCatalogEntity);
        return  newsCatalogConverter.toDto(newsCatalogEntity);
    }


    @Override
    public void delete(Integer id) {
        NewsCatalog newsCatalogEntity = getByIdThrowException(id);
        newCatalogRepo.delete(newsCatalogEntity);
    }

    @Override
    public Integer getNewId() {
        Integer newId = 0;
        NewsCatalog account = newCatalogRepo.findTopByOrderByIdDesc();
        if ((account != null)){
            newId = account.getId()+1;
        }
        return newId;
    }

    NewsCatalog postCatalogToPublicDB(NewsCatalog newsCatalog){
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<NewsCatalog> httpEntity = new HttpEntity<>(newsCatalog, headers);
            newsCatalog = restTemplate.postForObject("http://news/api/v1/news_catalog/", httpEntity, NewsCatalog.class);
        } catch (Exception e) {
            return newsCatalog;
        }

        return newsCatalog;
    }
}
