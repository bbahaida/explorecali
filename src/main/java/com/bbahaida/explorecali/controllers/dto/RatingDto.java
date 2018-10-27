package com.bbahaida.explorecali.controllers.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RatingDto {

    @Max(5)
    @Min(0)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer costumerId;

    public RatingDto(Integer score, String comment, Integer costumerId) {
        this.score = score;
        this.comment = comment;
        this.costumerId = costumerId;
    }

    protected RatingDto() {
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getCostumerId() {
        return costumerId;
    }

    public void setCostumerId(Integer costumerId) {
        this.costumerId = costumerId;
    }
}
