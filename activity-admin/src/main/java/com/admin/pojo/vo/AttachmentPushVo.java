package com.admin.pojo.vo;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AttachmentPushVo {
    @NotBlank(message = "gzOrderId不能为空")
    private String gzOrderId;

    @NotBlank(message = "userIdNo不能为空")
    private String userIdNo;

    @NotBlank(message = "attachmentType不能为空")
    private String attachmentType;

    @NotBlank(message = "fileBusiFlag不能为空")
    private String fileBusiFlag;

    @NotBlank(message = "attachmentName不能为空")
    private String attachmentName;

    @NotBlank(message = "url不能为空")
    private String url;

    @NotBlank(message = "goldcertBizType不能为空")
    private String goldcertBizType;
}
