package com.cfs.bms.repository;

import com.cfs.bms.entity.Movie;
import com.cfs.bms.entity.Theater;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie,Long> {


    List<Movie> findByGenre(String genre);
    List<Movie> findByLanguage(String language);
    List<Movie> findByTitleContainingIgnoreCase(String title);

}
