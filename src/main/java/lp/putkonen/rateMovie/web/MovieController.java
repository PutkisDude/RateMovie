package lp.putkonen.rateMovie.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
	
	@GetMapping("/")
	public String movies(Model model) {
		movieRepository.updateRatings();
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

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

				System.out.println("\n\n\n " + rating + "\n\n\n");

				model.addAttribute("movie", movie);
				model.addAttribute("rate", rating);
				page = "movie";
			}		
		return page;
	}
	
	@GetMapping("/addmovie")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		List<Genre> allGenres = (List<Genre>) genreRepository.findAll();
		model.addAttribute("genres", allGenres);
		return "add_movie";
	}
	
	@PostMapping("/savemovie")
	public String saveMovie(Movie movie, @RequestParam(value = "genres", required = false) int[] genress, BindingResult bindingresult, Model model) {
		
		for(int genre : genress) {
			movie.addGenre(genreRepository.findById((Long.valueOf(genre))).get());
		}
		movieRepository.save(movie);

		
		return "redirect:/";
	}
}
