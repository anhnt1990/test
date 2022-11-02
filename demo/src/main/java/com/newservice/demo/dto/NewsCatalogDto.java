package com.newservice.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsCatalogDto {
    private Integer id;
    private String catalogName;
    private String catalogHeader;
    private Integer whoCreate;
    private Date dateCreate;
    private String note;

}
