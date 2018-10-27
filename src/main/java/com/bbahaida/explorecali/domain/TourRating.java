package com.bbahaida.explorecali.domain;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class TourRating implements Serializable {

    @EmbeddedId
    private TourRatingPk tourRatingPk;

    @Column(nullable = false)
    private Integer score;

    private String comment;

    public TourRating() {
    }

    public TourRating(TourRatingPk tourRatingPk, Integer score, String comment) {
        this.tourRatingPk = tourRatingPk;
        this.score = score;
        this.comment = comment;
    }

    public TourRatingPk getTourRatingPk() {
        return tourRatingPk;
    }

    public void setTourRatingPk(TourRatingPk tourRatingPk) {
        this.tourRatingPk = tourRatingPk;
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

    @Override
    public String toString() {
        return "TourRating{" +
                "tourRatingPk=" + tourRatingPk +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRating that = (TourRating) o;
        return Objects.equals(tourRatingPk, that.tourRatingPk) &&
                Objects.equals(score, that.score) &&
                Objects.equals(comment, that.comment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourRatingPk, score, comment);
    }
}
