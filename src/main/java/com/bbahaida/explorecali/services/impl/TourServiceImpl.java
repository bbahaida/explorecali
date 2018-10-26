package com.bbahaida.explorecali.services.impl;

import com.bbahaida.explorecali.domain.Difficulty;
import com.bbahaida.explorecali.domain.Region;
import com.bbahaida.explorecali.domain.Tour;
import com.bbahaida.explorecali.domain.TourPackage;
import com.bbahaida.explorecali.repositories.TourPackageRepository;
import com.bbahaida.explorecali.repositories.TourRepository;
import com.bbahaida.explorecali.services.TourService;
import org.springframework.stereotype.Service;

@Service
public class TourServiceImpl implements TourService {

    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    public TourServiceImpl(TourRepository tourRepository, TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                           String keywords, String tourPackageName, Difficulty difficulty, Region region) {
        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if (tourPackage == null) throw new RuntimeException("Tour package does not exist: "+tourPackageName);
        return tourRepository.save(new Tour(title, description,blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    @Override
    public long total() {
        return tourRepository.count();
    }
}
