package lp.putkonen.rateMovie.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRepository;
import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class MovieController {

	
	  @Autowired 
	  private MovieRepository movieRepo;
	  
	  @Autowired
	  private UserRepository userRepository;
	  
	  @Autowired 
	  private RatingRepository ratingRepository;
	  
	  @GetMapping("/api/movies")
	  public @ResponseBody List<Movie> movieApi(){
		  movieRepo.updateRatings();
		  return  (List<Movie>) movieRepo.findAll();
	  }
	  
	  @GetMapping("/search/{title}")
	  public @ResponseBody List<Movie> searchMovie(@PathVariable("title") String title) {
		  movieRepo.updateRatings();
		  return (List<Movie>) movieRepo.findByTitleContainingIgnoreCase(title);
	  }
	  
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
				Movie movie = movieRepo.findById(movieId).get();
				Optional<User> user = userRepository.findById((long) 1);
				Rating rating;
				if(ratingRepository.existsByMovieAndUser(movie, user)) {
					 rating = ratingRepository.findByMovieAndUser(movie, user);
				} else {
					 rating = new Rating(movie);
				}				
				model.addAttribute("movie", movie);
				model.addAttribute("rate", rating);
				page = "movie";
			}
		return page;
	}
}
