package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRepository;
import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class MovieController {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private RatingRepository ratingRepository;
	
	// Index page
	@GetMapping("/") 
	public String movies(Model model) {
		movieRepository.updateRatings();
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	// Open page for movie - Add Movie and all ratings - Logged user can rate in that page
	@GetMapping("/movie/{id}")	
	public String moviePage(@PathVariable("id") Long movieId, Model model) {
		String page = "";
		
			if(movieRepository.findById(movieId).isEmpty()) {
				page =  "nosuchmovie";
			}else {
				Movie movie = movieRepository.findById(movieId).get();
				String auth =  SecurityContextHolder.getContext().getAuthentication().getName();
				User user = userRepository.findByUsername(auth);
				Rating rating;				
				if(ratingRepository.existsByMovieAndUser(movie, user)) {
					 rating = ratingRepository.findByMovieAndUser(movie, user);
				}else {
					 rating = new Rating(movie);
				}
				model.addAttribute("movie", movie);
				model.addAttribute("rate", rating);
				page = "movie";
			}		
		return page;
	}
	
	// Add new movie
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MOD')") 
	@GetMapping("/addmovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		List<Genre> allGenres = (List<Genre>) genreRepository.findAll();
		model.addAttribute("genres", allGenres);
		return "add_movie";
	}
	
	// Edit a movie
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MOD')") 
	@GetMapping("/editmovie/{id}")
	public String editMovie(Model model, @PathVariable("id") Long id) {
		model.addAttribute("movie", movieRepository.findById(id));
		List<Genre> allGenres = (List<Genre>) genreRepository.findAll();
		model.addAttribute("genres", allGenres);
		return "add_movie";
	}
	
	// Delete movie
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/deletemovie/{id}")
	public String deleteMovie(@PathVariable("id") Long id) {
		if(movieRepository.existsById(id)) {
			movieRepository.deleteById(id);
		}
		return "redirect:/";
	}
	
	// Save a movie. Genres in array = Loop
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'MOD')") 
	@PostMapping("/savemovie")
	public String saveMovie(Movie movie, @RequestParam(value = "genres", required = false) int[] genress, BindingResult bindingresult, Model model)  throws NumberFormatException{
		
		
		if(genress != null) {
			for(int genre : genress) {
				movie.addGenre(genreRepository.findById((Long.valueOf(genre))).get());
			}
		}
		movieRepository.save(movie);
		return "redirect:/";
	}
}
