package com.cfs.bms.controller;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Screen;
import com.cfs.bms.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    //add movie hw
    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.addMovie(movie));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title){
        return ResponseEntity.ok(movieService.searchByTitle(title));

    }
    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable String genre){
        return ResponseEntity.ok(movieService.searchByGenre(genre));
    }
    @GetMapping("/language/{language}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String language){
        return ResponseEntity.ok(movieService.searchByLanguage(language));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie movie){
        return ResponseEntity.ok(movieService.updateMovie(id,movie));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return ResponseEntity.ok("Movie deleted Successfully");
    }
}
