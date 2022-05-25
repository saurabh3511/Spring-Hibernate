package com.app.AmazonePrime.AmazonePrime.service;

import com.app.AmazonePrime.AmazonePrime.dao.MovieRepository;
import com.app.AmazonePrime.AmazonePrime.dto.MovieDto;
import com.app.AmazonePrime.AmazonePrime.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieDtoService {

    private MovieRepository movieRepository;

    @Autowired
    public MovieDtoService(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }

    public List<MovieDto> findAll(){
        return ((List<Movie>) movieRepository
                .findAll())
                .stream()
                .map(this::convertDataIntoDTO)
                .collect(Collectors.toList());
    }

    private MovieDto convertDataIntoDTO(Movie movie) {
        MovieDto dto = new MovieDto();
        dto.setMovieId(movie.getMovieId());
        dto.setMovieName(movie.getMovieName());
        dto.setGenre(movie.getGenre());
        dto.setLanguage(movie.getLanguage());


        return dto;
    }


}
