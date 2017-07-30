package com.moviesintown.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.moviesintown.data.Movie;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Repository
public class MovieRepository {

    private static final String FIND_URL = "https://api.themoviedb.org/3/search/movie?api_key={api_key}&query={query}";
    private static final String QUERY_URL = "https://api.themoviedb.org/3/movie/{movie_id}?api_key={api_key}";
    private static final String API_KEY = "6a272eb29d1a51c06acc48b205def70d";
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-DD");

    public Optional<Movie> getMovieById(Integer movieId) throws ParseException {
        JsonNode result = REST_TEMPLATE.getForObject(QUERY_URL, JsonNode.class, movieId, API_KEY);
        return Optional.of(parseJsonNode(result));
    }

    public Optional<Movie> findMovie(String query) throws ParseException {
        JsonNode root = REST_TEMPLATE.getForObject(FIND_URL, JsonNode.class, API_KEY, query);
        JsonNode results = root.get("results");
        if (results.size() == 0) {
            return Optional.empty();
        }
        JsonNode firstResult = results.get(0);
        return Optional.of(parseJsonNode(firstResult));
    }

    private Movie parseJsonNode(JsonNode movieJsonNode) throws ParseException {
        String id = movieJsonNode.get("id").asText().toString();
        String title = movieJsonNode.get("title").asText().toString();
        Date releaseDate = DATE_FORMAT.parse(movieJsonNode.get("release_date").asText().toString());
        return new Movie(id, title, releaseDate);
    }
}
