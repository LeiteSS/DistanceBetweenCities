/**
 * BAD PRACTICE
 */
package com.github.leitess.citiesApi.resource;

import com.github.leitess.citiesApi.entity.State;
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
@RequestMapping("/states")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StateResource {

    private StateRepository repoState;

    @GetMapping
    public Page<State> states(Pageable pageable) {
        return repoState.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneState(@PathVariable Long id) {
        Optional<State> optState = repoState.findById(id);

        if (optState.isPresent()) {
            return ResponseEntity
                    .ok()
                    .body(optState.get());
        } else {
            return ResponseEntity
                    .notFound()
                    .build();
        }
    }
}
