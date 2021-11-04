package lp.putkonen.rateMovie.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;
	
	@GetMapping("/genre-api")
	public @ResponseBody List<Genre> index() {
		return (List<Genre>) genreRepo.findAll();
	}
	
	@GetMapping("/genres")
	public String genreList(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "genres";
	}
}
