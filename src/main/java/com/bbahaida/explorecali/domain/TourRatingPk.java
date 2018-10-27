package com.bbahaida.explorecali.domain;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

public class TourRatingPk implements Serializable {
    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer costumerId;

    public TourRatingPk() {
    }

    public TourRatingPk(Tour tour, Integer costumerId) {
        this.tour = tour;
        this.costumerId = costumerId;
    }

    public Tour getTour() {
        return tour;
    }

    public Integer getCostumerId() {
        return costumerId;
    }

    @Override
    public String toString() {
        return "TourRatingPk{" +
                "tour=" + tour +
                ", costumerId=" + costumerId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourRatingPk that = (TourRatingPk) o;
        return Objects.equals(tour, that.tour) &&
                Objects.equals(costumerId, that.costumerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tour, costumerId);
    }
}
