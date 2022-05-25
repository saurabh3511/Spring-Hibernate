package com.app.AmazonePrime.AmazonePrime.dao;


import com.app.AmazonePrime.AmazonePrime.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
