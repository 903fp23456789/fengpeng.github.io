package com.admin.pojo.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NotarizationVo {

    @NotBlank(message = "gzOrderId不能为空")
    private String gzOrderId;

}
