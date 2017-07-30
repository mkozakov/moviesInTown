package com.moviesintown.service;

import com.moviesintown.data.Movie;
import com.moviesintown.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public Optional<Movie> findMovie(String query) throws ParseException {
        return movieRepository.findMovie(query);
    }
}
