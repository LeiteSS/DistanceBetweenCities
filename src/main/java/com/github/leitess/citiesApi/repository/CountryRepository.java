package com.github.leitess.citiesApi.repository;

import com.github.leitess.citiesApi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
