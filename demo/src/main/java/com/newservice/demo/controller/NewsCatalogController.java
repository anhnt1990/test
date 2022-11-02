package com.newservice.demo.controller;


import com.newservice.demo.service.interfaces.NewsCatalogService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class NewsCatalogController {

    @Autowired
    private NewsCatalogService newsCatalogService;
}
