package com.arbade.gjc.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import javax.persistence.Entity;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score {

    @Transient
    @JsonProperty(value = "user_id")
    private String id;

    @JsonProperty("score_worth")
    private double scoreWorth;

    @JsonProperty("timestamp")
    private Date timestamp;

}
