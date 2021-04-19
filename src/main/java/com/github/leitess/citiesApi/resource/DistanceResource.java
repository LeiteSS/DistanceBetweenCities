/**
 * GOOD PRACTICE: ALWAYS MUST HAVE A INTERMEDIATE LAYER BETWEEN CONTROLLER AND ENTITY
 */
package com.github.leitess.citiesApi.resource;

import com.github.leitess.citiesApi.entity.enums.EarthRadius;
import com.github.leitess.citiesApi.service.DistanceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/distance")
public class DistanceResource {

    Logger log = LoggerFactory.getLogger(DistanceResource.class);

    private final DistanceService distanceService;

    public DistanceResource(DistanceService distanceService) {
        this.distanceService = distanceService;
    }

    @GetMapping("/by-points")
    public Double byPoints(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byPoints");
        return distanceService.distanceByPointsInMiles(city1, city2);
    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestParam(name = "from") final Long city1,
                           @RequestParam(name = "to") final Long city2) {
        log.info("byCube");
        return distanceService.distanceByCubeInMeters(city1, city2);
    }

    @GetMapping("/by-math")
    public Double byMath(@RequestParam(name = "from") final Long city1,
                         @RequestParam(name = "to") final Long city2,
                         @RequestParam final EarthRadius unit) {
        log.info("byMath");
        return distanceService.distanceUsingMath(city1, city2, unit);
    }
}
