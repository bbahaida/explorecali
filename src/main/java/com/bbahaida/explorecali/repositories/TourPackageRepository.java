package com.bbahaida.explorecali.repositories;

import com.bbahaida.explorecali.domain.TourPackage;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(collectionResourceRel = "packages", path = "packages")
public interface TourPackageRepository extends PagingAndSortingRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);

    @Override
    @RestResource(exported = false)
    void delete(String s);
}
