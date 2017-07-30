package com.moviesintown.data;

import lombok.Value;

import java.util.Date;

@Value
public class Movie {

    private final String id;
    private final String title;
    private final Date releaseDate;
}
