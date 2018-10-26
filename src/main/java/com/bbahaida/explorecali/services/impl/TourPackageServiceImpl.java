package com.bbahaida.explorecali.services.impl;

import com.bbahaida.explorecali.domain.TourPackage;
import com.bbahaida.explorecali.repositories.TourPackageRepository;
import com.bbahaida.explorecali.services.TourPackageService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageServiceImpl implements TourPackageService {

    private TourPackageRepository tourPackageRepository;

    public TourPackageServiceImpl(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    @Override
    public void createTourPackage(String code, String name) {
        this.tourPackageRepository.save(new TourPackage(code,name));
    }

    @Override
    public List<TourPackage> lookup() {
        return (List<TourPackage>) this.tourPackageRepository.findAll();
    }
}
