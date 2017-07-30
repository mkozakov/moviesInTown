package com.moviesintown.controller;

import com.moviesintown.data.Movie;
import com.moviesintown.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/find")
    public Movie findMovie(@RequestParam String query) throws ParseException {
        return movieService.findMovie(query).orElseThrow(() -> new ResourceNotFoundException());
    }
}
