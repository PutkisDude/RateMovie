package lp.putkonen.rateMovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import lp.putkonen.rateMovie.domain.MovieRepository;

@Controller
public class MovieController {

	
	  @Autowired 
	  private MovieRepository movieRepo;
	  
	  @GetMapping("/")
	public String movies(Model model) {
		movieRepo.updateRatings();
		model.addAttribute("movies", movieRepo.findAll());
		return "index";
	}
	
	@GetMapping("/movie/{id}")
	public String moviePage(@PathVariable("id") Long movieId, Model model) {
		String page = "";
			if(movieRepo.findById(movieId).isEmpty()) {
				page =  "nosuchmovie";
			}else {
				model.addAttribute("movie", movieRepo.findById(movieId).get());
				page = "movie";
			}
		return page;
	}
}
