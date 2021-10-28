package lp.putkonen.rateMovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	private MovieRepository movieRepo;
	@Autowired
	private GenreRepository genreRepo;
	
	@GetMapping("*")
	public String index(Model model) {
		return "index";
	}
}
