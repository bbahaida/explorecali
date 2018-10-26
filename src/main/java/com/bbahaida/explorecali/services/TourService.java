package com.bbahaida.explorecali.services;

import com.bbahaida.explorecali.domain.Difficulty;
import com.bbahaida.explorecali.domain.Region;
import com.bbahaida.explorecali.domain.Tour;
import com.bbahaida.explorecali.domain.TourPackage;

public interface TourService {
    Tour createTour(String title, String description, String blurb, Integer price, String duration, String bullets,
                    String keywords, String tourPackageName, Difficulty difficulty, Region region);

    long total();
}
