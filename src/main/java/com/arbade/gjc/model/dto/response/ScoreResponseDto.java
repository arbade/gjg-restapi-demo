package com.arbade.gjc.model.dto.response;

import lombok.Data;

import java.util.Date;

@Data
public class ScoreResponseDto {

    private String id;
    private double scoreWorth;
    private Date timestamp;

}
