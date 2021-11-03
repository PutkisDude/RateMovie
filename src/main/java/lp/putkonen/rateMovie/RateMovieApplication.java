package lp.putkonen.rateMovie;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRatingRepository;
import lp.putkonen.rateMovie.domain.MovieRepository;
import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@SpringBootApplication
public class RateMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(RateMovieApplication.class, args);
	}
	
	@Bean
	public <S> CommandLineRunner oneliner (GenreRepository genreRepo, MovieRepository movieRepo, RatingRepository rateRepo, MovieRatingRepository mvrateRepo, UserRepository userRepo ) {
		return (args) -> {
			
			User user1 = new User("John Doe", "pswd");
			User user2 = new User("Jane Doe", "pswd2");
			userRepo.save(user1);
			userRepo.save(user2);
			
			Genre horror = new Genre("Horror");
			Genre fantasy = new Genre("Fantasy");
			Genre comedy = new Genre("Comedy");
			Genre drama = new Genre("Drama");
			Genre musical = new Genre("Musical");
			Genre animation = new Genre("Animation");
			genreRepo.save(horror);
			genreRepo.save(fantasy);
			genreRepo.save(comedy);
			genreRepo.save(drama);
			genreRepo.save(musical);
			genreRepo.save(animation);
			
			Movie nightmareBefore = new Movie("Nightmare Before Christmas", 1993, 76);
			Movie lit = new Movie("Lost in Translation", 2003, 101);
			Movie mov = new Movie("Lost in Translation", 2003, 101);
			Movie mov2 = new Movie("Lost in Translation", 2003, 101);
			Movie mov3 = new Movie("Lost in Translation", 2003, 101);
			
			movieRepo.save(mov);
			movieRepo.save(mov2);
			movieRepo.save(mov3);
		
			lit.addGenre(drama);
			lit.addGenre(comedy);
						
			nightmareBefore.addGenre(musical);
			nightmareBefore.addGenre(animation);
			nightmareBefore.addGenre(comedy);
			
			movieRepo.save(lit);
			movieRepo.save(nightmareBefore);
			
			rateRepo.save(new Rating(user1, lit, 5, "Great Movie"));
			rateRepo.save(new Rating(user2, mov3, 4, "Awsum"));
			rateRepo.save(new Rating(user1, mov, 1, "Shiet"));
			rateRepo.save(new Rating(user2, mov2, 4, "Awsum"));
			rateRepo.save(new Rating(user2, mov, 4, "Oh ye"));
			rateRepo.save(new Rating(user2, lit, 5, "Awsum"));
			

					
//			MovieRating rating = new MovieRating(user1, lit, rate1);
//			rateRepo.save(rating);
		};
	}
}
