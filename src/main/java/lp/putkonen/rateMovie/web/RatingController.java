package lp.putkonen.rateMovie.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class RatingController {

	@Autowired
	private RatingRepository rateRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@GetMapping("/api/ratings")
	public @ResponseBody List<Rating> ratingApi(){	
		return (List<Rating>) rateRepo.findAll();
	}
	
	@GetMapping("/rating")
	public String index(Model model) {
		model.addAttribute("ratings", rateRepo.findAll());
		return "rating";
	}
	
	@GetMapping("/rating/{id}")
	public String testRate(@PathVariable("id") Long id, Model model) {
		Optional<User> us = userRepo.findById((long) 1);
		model.addAttribute("rating", new Rating());
		
		return null;
	}
	
	@PostMapping("/rate")
	public void rateMovie(Movie movie, User user) {
		
	}
}
