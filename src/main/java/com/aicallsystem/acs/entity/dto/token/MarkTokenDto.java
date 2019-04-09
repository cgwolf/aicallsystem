package com.aicallsystem.acs.entity.dto.token;

import lombok.Data;

@Data
public class MarkTokenDto {

    private String token;

    public MarkTokenDto(String token) {
        this.token = token;
    }
}
