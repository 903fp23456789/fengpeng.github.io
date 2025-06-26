package com.admin.pojo.dto;

import lombok.Data;

@Data
public class LoginDto {
    private String transStatus;

    private String transMsg;

    private String username;

    private String token;

    public LoginDto() {
    }

    public LoginDto(String transStatus, String transMsg, String username, String token) {
        this.transStatus = transStatus;
        this.transMsg = transMsg;
        this.username = username;
        this.token = token;
    }
}
