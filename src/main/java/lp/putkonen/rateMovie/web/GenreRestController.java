package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;

@RestController
@CrossOrigin
public class GenreRestController {

	@Autowired
	private GenreRepository genreRepository;
	
	@GetMapping("/api/genres")
	public @ResponseBody List<Genre> index() {
		return (List<Genre>) genreRepository.findAll();
	}
		
}
