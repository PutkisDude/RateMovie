package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRepository;

@RestController
@CrossOrigin
public class MovieRestController {

	
	  @Autowired 
	  private MovieRepository movieRepo;
	  
	  @GetMapping("/api/movies")
	  public @ResponseBody List<Movie> movieApi(){
		  movieRepo.updateRatings();
		  return  (List<Movie>) movieRepo.findAll();
	  }
	  	  
	  @GetMapping("api/movies/search/{title}")
	  public @ResponseBody List<Movie> searchMovie(@PathVariable("title") String title) {
		  movieRepo.updateRatings();
		  return (List<Movie>) movieRepo.findByTitleContainingIgnoreCase(title);
	  }
	 
}
