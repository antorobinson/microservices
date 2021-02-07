package com.anto.catalog.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.anto.catalog.model.Catalog;
import com.anto.catalog.model.CatalogItems;
import com.anto.catalog.model.Movie;
import com.anto.catalog.model.UserRatings;

@RestController
@RequestMapping("/catalog")
public class CatalogController {
	
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/user/{user_id}")
	public CatalogItems getMethod(@PathVariable("user_id") String userId) {
		
		UserRatings userRatings=restTemplate.getForObject("http://movie-rating-service/rating/user/"+userId, UserRatings.class);
		
		List<Catalog> catalogs = userRatings.getUserRatings().stream().map( rating ->{
			Movie movie = restTemplate.getForObject("http://movie-info-service/info/movie/"+rating.getMovieId(), Movie.class);
			
			return new Catalog(rating.getMovieId(),movie.getMovieName(),rating.getRating());
		}).collect(Collectors.toList());
		   
		   CatalogItems items = new CatalogItems(catalogs);
		
		return items;
	}
}
