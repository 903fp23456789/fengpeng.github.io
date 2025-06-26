package com.admin.pojo.dto;

import lombok.Data;

@Data
public class UrlListDto {
    private String pname;

    private String pvalue;

    private String pkey;

    public UrlListDto(String pname, String pvalue, String pkey) {
        this.pname = pname;
        this.pvalue = pvalue;
        this.pkey = pkey;
    }
}
