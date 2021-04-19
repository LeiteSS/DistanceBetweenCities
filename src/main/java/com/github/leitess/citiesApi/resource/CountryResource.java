/**
 * BAD PRACTICE
 */
package com.github.leitess.citiesApi.resource;

import com.github.leitess.citiesApi.entity.Country;
import com.github.leitess.citiesApi.entity.State;
import com.github.leitess.citiesApi.repository.CountryRepository;
import com.github.leitess.citiesApi.repository.StateRepository;
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
@RequestMapping("/countries")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryResource {

    private CountryRepository repoCountry;


    @GetMapping
    public Page<Country> countries(Pageable pageable) {
        return repoCountry.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneCountry(@PathVariable Long id) {
        Optional<Country> optCountry = repoCountry.findById(id);

        if (optCountry.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(optCountry.get());
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
