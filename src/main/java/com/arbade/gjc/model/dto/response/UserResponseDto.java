package com.arbade.gjc.model.dto.response;


import lombok.Data;


@Data
public class UserResponseDto {

    private String uuid;
    private String displayName;
    private double points;
    private long rank;

}
