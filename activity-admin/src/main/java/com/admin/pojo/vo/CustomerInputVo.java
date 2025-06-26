package com.admin.pojo.vo;

import jakarta.validation.constraints.NotBlank;
import jakarta.websocket.server.PathParam;
import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CustomerInputVo {
    @NotBlank(message = "gzOrderId不能为空")
    private String gzOrderId;

    @NotBlank(message = "goldcertBizType不能为空")
    private String goldcertBizType;

    @NotBlank(message = "lendStarttime不能为空")
    private String lendEndtime;

    @NotBlank(message = "lendEndtime不能为空")
    private String lendStarttime;

    @NotBlank(message = "lenderName不能为空")
    private String lenderName;

    @NotBlank(message = "applicantName不能为空")
    private String applicantName;

    @NotBlank(message = "applicantID不能为空")
    private String applicantID;

    @NotBlank(message = "applicantPhone不能为空")
    private String applicantPhone;

    @NotBlank(message = "applicantAddress不能为空")
    private String applicantAddress;

    @NotBlank(message = "amount不能为空")
    private String amount;

    @NotBlank(message = "goodsNum不能为空")
    private String goodsNum;

    @NotBlank(message = "platformName不能为空")
    private String platformName;

    @NotBlank(message = "merchantName不能为空")
    private String merchantName;

    @NotBlank(message = "coDebtor不能为空")
    private String coDebtor;

    private String notaryInfo;

    private String cbUrl;

    private String lenderNo;
}
