package com.arbade.gjc.model.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Document(collection = "user_info")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @JsonProperty("user_id")
    @Id
    private String uuid = UUID.randomUUID().toString();

    @JsonProperty("display_name")
    private String displayName;
    @JsonProperty("country")
    private String country;
    @JsonProperty("points")
    private long points;
    @JsonProperty("high_score")
    private long highScore;
    @JsonProperty
    private List<Score> scores = new LinkedList<>();
    @Transient
    @JsonProperty("global_rank")
    private long globalRank;
    @Transient
    @JsonProperty("local_rank")
    private long localRank;


}
