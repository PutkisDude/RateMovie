package lp.putkonen.rateMovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.MovieRepository;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
public class GenreController {
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	MovieRepository movieRepository;

	@GetMapping("/genres")
	public String genreList(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genres";
	}
				
	@GetMapping("/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "add_genre";
	}
	
	@GetMapping("/renamegenre/{id}") 
	public String renameGenre(@PathVariable("id") Long genreId, Model model) {
		model.addAttribute("genre", genreRepository.findById(genreId)); 
		return "add_genre"; 
		}
	
	@PostMapping("/savegenre") public String saveGenre(Genre genre) {
		genreRepository.save(genre); 
		return "redirect:genres"; 
	  }
}
