package lp.putkonen.rateMovie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;

@Controller
public class RatingController {

	@Autowired
	private RatingRepository rateRepo;
	
	@GetMapping("/api/rating")
	public @ResponseBody List<Rating> ratingApi(){	
		return (List<Rating>) rateRepo.findAll();
	}
	
	@GetMapping("/rating")
	public String index(Model model) {
		model.addAttribute("ratings", rateRepo.findAll());
		return "rating";
	}
}
