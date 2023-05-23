package com.ssafy.trip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.trip.dto.Spot;
import com.ssafy.trip.model.service.SpotService;

@RestController
@RequestMapping("/spot")
@CrossOrigin
public class SpotController {
    private final Logger logger = LoggerFactory.getLogger(SpotController.class);

private final SpotService spotService;

@Autowired
public SpotController(SpotService spotService) {
    this.spotService = spotService;
}

@GetMapping("")
public ModelAndView index() {
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("spot/search");
    return modelAndView;
}

@GetMapping("/sido")
public ResponseEntity<?> getSido() {
    try {
        List<String[]> sidos = spotService.getSidoList();
        if (sidos != null && !sidos.isEmpty()) {
            return new ResponseEntity<List<String[]>>(sidos, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/{sidoid}")
public ResponseEntity<?> getSido(@PathVariable() int sidoid) {
    try {
        List<String[]> guguns = spotService.getGugunList(sidoid);
        if (guguns != null && !guguns.isEmpty()) {
            return new ResponseEntity<List<String[]>>(guguns, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/{sidoId}/{gugunId}")
public ResponseEntity<?> getSido(@PathVariable() int sidoId, @PathVariable() int gugunId) {
    Map<String, Integer> map = new HashMap<>();
    map.put("sidoId", sidoId);
    map.put("gugunId", gugunId);
    System.out.println(map.get("sidoId") + " " + map.get("gugunId"));
    try {
        List<Spot> spots = spotService.getSpotList(map);
        if (spots != null && !spots.isEmpty()) {
            return new ResponseEntity<List<Spot>>(spots, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/search/{keyword}")
public ResponseEntity<?> searchSpot(@PathVariable() String keyword) {
    try {
        List<Spot> spots = spotService.searchSpot(keyword);
        if (spots != null && !spots.isEmpty()) {
            return new ResponseEntity<List<Spot>>(spots, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/detail/{contentId}")
public ResponseEntity<?> getSpotDetail(@PathVariable() int contentId) {
    try {
        Spot spot = spotService.getSpot(contentId);
        if (spot != null) {
            return new ResponseEntity<Spot>(spot, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/top/{contentTypeId}")
public ResponseEntity<?> getThemeTopSpot(@PathVariable() String contentTypeId) {
    try {
        Spot spot = spotService.getThemeTopSpot(contentTypeId);
        if (spot != null) {
            return new ResponseEntity<Spot>(spot, HttpStatus.OK);
        } else {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

private ResponseEntity<String> exceptionHandling(Exception e) {
    return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}