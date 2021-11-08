package lp.putkonen.rateMovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lp.putkonen.rateMovie.domain.RatingRepository;

@Controller
public class RatingController {

	@Autowired
	private RatingRepository rateRepo;
	
	@GetMapping("/rating")
	public String index(Model model) {
		model.addAttribute("ratings", rateRepo.findAll());
		return "rating";
	}
}
