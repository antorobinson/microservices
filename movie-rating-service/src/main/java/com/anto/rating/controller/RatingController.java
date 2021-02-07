package com.anto.rating.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anto.rating.model.Rating;
import com.anto.rating.model.UserRatings;

@RestController
@RequestMapping("/rating")
public class RatingController {

	@GetMapping("/user/{user_id}")
	public UserRatings getMethod(@PathVariable("user_id") String userId) {
		
		List<Rating> Ratings = Arrays.asList(
				new Rating("movie1", 6),
				new Rating("movie2",7)
				);
		
		UserRatings userRatings = new UserRatings();
		userRatings.setUserRatings(Ratings);
		
		return userRatings;
	}
}
