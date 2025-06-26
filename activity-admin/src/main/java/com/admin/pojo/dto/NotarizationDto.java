package com.admin.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotarizationDto {
    @NotBlank(message = "transStaus不能为空")
    private String transStaus;      // 000000:成功

    @NotBlank(message = "transMsg不能为空")
    private String transMsg;

    public NotarizationDto(String transStaus, String transMsg) {
        this.transMsg = transMsg;
        this.transStaus = transStaus;
    }
}
