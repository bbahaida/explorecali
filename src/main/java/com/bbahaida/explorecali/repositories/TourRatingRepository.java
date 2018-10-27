package com.bbahaida.explorecali.repositories;


import com.bbahaida.explorecali.domain.TourRating;
import com.bbahaida.explorecali.domain.TourRatingPk;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends JpaRepository<TourRating, TourRatingPk> {

    List<TourRating> findByTourRatingPkTourId(Integer tourId);
    Page<TourRating> findByTourRatingPkTourId(Integer tourId, Pageable pageable);
    TourRating findByTourRatingPkTourAndTourRatingPkCostumerId(Integer tourId, Integer costumerId);
}
