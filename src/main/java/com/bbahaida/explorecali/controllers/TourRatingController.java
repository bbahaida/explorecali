package com.bbahaida.explorecali.controllers;


import com.bbahaida.explorecali.controllers.dto.RatingDto;
import com.bbahaida.explorecali.domain.Tour;
import com.bbahaida.explorecali.domain.TourRating;
import com.bbahaida.explorecali.domain.TourRatingPk;
import com.bbahaida.explorecali.repositories.TourRatingRepository;
import com.bbahaida.explorecali.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/tours/{tourId}/ratings")
public class TourRatingController {
    private TourRepository tourRepository;
    private TourRatingRepository tourRatingRepository;

    @Autowired
    public TourRatingController(TourRepository tourRepository, TourRatingRepository tourRatingRepository) {
        this.tourRepository = tourRepository;
        this.tourRatingRepository = tourRatingRepository;
    }

    protected TourRatingController() {
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable("tourId") int tourid, @RequestBody @Validated RatingDto ratingDto){
        Tour tour = verifyTour(tourid);
        tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCostumerId()),
                ratingDto.getScore(), ratingDto.getComment()));
    }

    @GetMapping
    public Page<RatingDto> getAllRatings(@PathVariable("tourId") int tourId, Pageable pageable){
        verifyTour(tourId);
        Page<TourRating> ratingsPage = tourRatingRepository.findByTourRatingPkTourId(tourId, pageable);

        List<RatingDto> ratingsList = ratingsPage.getContent().stream().map(t -> toDto(t)).collect(Collectors.toList());

        return new PageImpl<RatingDto>(ratingsList, pageable, ratingsPage.getTotalPages());
    }

    @GetMapping("/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable("tourId") int tourId){
        verifyTour(tourId);
        OptionalDouble average = tourRatingRepository.findByTourRatingPkTourId(tourId).stream().mapToInt(TourRating::getScore).average();
        return new AbstractMap.SimpleEntry<String, Double>("average", average.isPresent()?average.getAsDouble():null);

    }

    private RatingDto toDto(TourRating tourRating){
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getTourRatingPk().getCostumerId());
    }

    private Tour verifyTour(int tourId) throws NoSuchElementException {
        Tour tour = tourRepository.findOne(tourId);
        if (tour == null){
            throw new NoSuchElementException("Tour does not exist: "+tourId);
        }
        return tour;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return404(NoSuchElementException ex){
        return ex.getMessage();
    }


}
