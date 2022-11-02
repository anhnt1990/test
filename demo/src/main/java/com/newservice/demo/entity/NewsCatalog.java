package com.newservice.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "NEWS_CATALOG")
public class NewsCatalog {
    @Id
    @Column(name = "ID")
    private  Integer id;

    @Column(name = "CATALOG_NAME")
    private String catalogName;

    @Column(name = "CATALOG_HEADER")
    private String catalogHeader;

    @Column(name = "WHO_CREATE")
    private Integer whoCreate;

    @Column(name= "DATE_CREATE")
    private Date dateCreate;

    @Column(name = "NOTE")
    private String note;
}
