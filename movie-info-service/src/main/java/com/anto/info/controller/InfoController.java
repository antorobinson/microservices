package com.anto.info.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anto.info.model.Movie;

@RestController
@RequestMapping("/info")
public class InfoController {

	@GetMapping("/movie/{movie_id}")
	public Movie getMethod(@PathVariable("movie_id") String movieId) {
		
		return new Movie(movieId,"Fast and Furious");
	}
}
