package com.arbade.gjc.model.dto;


import lombok.Data;

@Data
public class UserDto {

    private String uuid;
    private String displayName;
    private String country;
    private long points;
    private long highScore;

}
