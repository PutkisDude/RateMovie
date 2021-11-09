package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;

@Controller
public class GenreController {

	@Autowired
	private GenreRepository genreRepo;
	
	@GetMapping("/api/genres")
	public @ResponseBody List<Genre> index() {
		return (List<Genre>) genreRepo.findAll();
	}
	
	@GetMapping("/genres")
	public String genreList(Model model) {
		model.addAttribute("genres", genreRepo.findAll());
		return "genres";
	}
	
	@GetMapping("/addgenre")
	public String addGenre(Model model) {
		model.addAttribute("genre", new Genre());
		return "add_genre";
	}
	
	  @GetMapping("/renamegenre/{id}") 
	  public String renameGenre(@PathVariable("id") Long genreId, Model model) {
		  System.out.println("TOPFEWOPFEWOPFEWOPFEW " + genreRepo.findById(genreId));
		  model.addAttribute("genre", genreRepo.findById(genreId)); 
		  return "add_genre"; }
	  

	  @PostMapping("/savegenre") public String saveGenre(Genre genre) {
		  genreRepo.save(genre); 
		  return "redirect:genres"; 
	  }
	 
}
