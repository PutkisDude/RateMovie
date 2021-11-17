package lp.putkonen.rateMovie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;

@RestController
@CrossOrigin
public class RatingRestController {

	@Autowired
	private RatingRepository ratingRepository;
	
	@GetMapping("/api/ratings")
	public @ResponseBody List<Rating> ratingApi(){	
		return (List<Rating>) ratingRepository.findAll();
	}
}
