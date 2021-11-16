package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class RatingController {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/api/ratings")
	public @ResponseBody List<Rating> ratingApi(){	
		return (List<Rating>) ratingRepository.findAll();
	}
		
	@GetMapping("/rating/{id}")
	public String testRate(@PathVariable("id") Long id, Model model) {
		model.addAttribute("rating", new Rating());	
		return null;
	}
	
	@GetMapping("/rating")
	public String index(Model model) {
		model.addAttribute("ratings", ratingRepository.findAll());
		return "rating";
	}
	
	@PostMapping("/rate")
	public String rateMovie(Rating rating) {
				
		Rating tempRate = rating;
		String auth =  SecurityContextHolder.getContext().getAuthentication().getName();
		User user = userRepository.findByUsername(auth);

		if(tempRate.getRatingId() != null) {
			Rating realRate = ratingRepository.findById(rating.getRatingId()).get();	
			realRate.setPoints(tempRate.getPoints());
			realRate.setComment(tempRate.getComment());
			ratingRepository.save(realRate);
		} else {
			tempRate.setUser(user);
			ratingRepository.save(tempRate);
		}
						
		return "redirect:/";
		
	}
}
