package com.github.leitess.citiesApi.repository;

import com.github.leitess.citiesApi.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
