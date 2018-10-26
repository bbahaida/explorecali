package com.bbahaida.explorecali.services;

import com.bbahaida.explorecali.domain.TourPackage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TourPackageService {
    void createTourPackage(String code, String name);
    List<TourPackage> lookup();
}
