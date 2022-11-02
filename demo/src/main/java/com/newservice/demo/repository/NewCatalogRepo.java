package com.newservice.demo.repository;

import com.newservice.demo.entity.NewsCatalog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewCatalogRepo extends JpaRepository<NewsCatalog,Integer> {

    NewsCatalog findTopByOrderByIdDesc();

}
