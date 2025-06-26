package com.admin.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerInputDto {
    @NotBlank(message = "serialNo不能为空")
    private String serialNo;

    @NotBlank(message = "transStaus不能为空")
    private String transStaus;

    @NotBlank(message = "transMsg不能为空")
    private String transMsg;

    public CustomerInputDto(String transStaus, String transMsg) {
        this.serialNo = null;
        this.transStaus = transStaus;
        this.transMsg = transMsg;
    }
}
