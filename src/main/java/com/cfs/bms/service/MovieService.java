package com.cfs.bms.service;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Theater;
import com.cfs.bms.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }
    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }
    public Movie getMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("movie not found with id:"+id));
    }
    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }
    public List<Movie> searchByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> searchByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }
    //update movie hw
    public Movie updateMovie(Long id,Movie movie){
        Movie existingMovie=movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with id"+id));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setDescription(movie.getDescription());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setDurationMinutes(movie.getDurationMinutes());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setRating(movie.getRating());
        existingMovie.setPosterUrl(movie.getPosterUrl());
        return movieRepository.save(existingMovie);
    }
    //delete movie hw
    public void deleteMovie(Long id){
        Movie existingMovie=movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("movie not found with id"+id));
        movieRepository.delete(existingMovie);
    }


}
