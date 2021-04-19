/**
 * BAD PRACTICE
 */
package com.github.leitess.citiesApi.resource;

import com.github.leitess.citiesApi.entity.City;
import com.github.leitess.citiesApi.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CityResource {

    private CityRepository repoCity;


    @GetMapping
    public Page<City> cities(Pageable pageable) {
        return repoCity.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCity(@PathVariable Long id) {
        Optional<City> optCity = repoCity.findById(id);

        if (optCity.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(optCity.get());
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
