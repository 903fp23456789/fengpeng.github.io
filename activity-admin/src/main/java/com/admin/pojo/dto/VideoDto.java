package com.admin.pojo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class VideoDto {
    @NotBlank(message = "transStaus不能为空")
    private String transStaus;

    @NotBlank(message = "transMsg不能为空")
    private String transMsg;

    @NotBlank(message = "urlListDto不能为空")
    private UrlListDto urlListDto;

    public VideoDto(String transStaus, String transMsg, UrlListDto urlListDto){
        this.transStaus = transStaus;
        this.transMsg = transMsg;
        this.urlListDto = urlListDto;
    }
}
