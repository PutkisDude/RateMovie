package lp.putkonen.rateMovie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import lp.putkonen.rateMovie.domain.Genre;
import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRepository;
import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@SpringBootApplication
public class RateMovieApplication {
	private static final Logger log = LoggerFactory.getLogger(RateMovieApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RateMovieApplication.class, args);
	}
	
	@Bean
	public <S> CommandLineRunner oneliner (GenreRepository genreRepo, MovieRepository movieRepo, RatingRepository rateRepo, UserRepository userRepo ) {
		return (args) -> {
			
			// pwsd = test
			User user1 = new User("John Doe", "$2a$10$MlPPKBr4033nUemRZysCLOEp6kwkdPDzBuQ8cNruZA6Ta1T8SLYp6");
			
			// pwsd = test2
			User user2 = new User("Jane Doe", "$2a$10$Yb7hbb6nmHrPh0S6PrHZjOwMkFEIM1bUBAh27b1KU56Lw1clmOkEC");
			userRepo.save(user1);
			userRepo.save(user2);
			
			// pwsd = testing
			userRepo.save(new User("Test", "$2a$10$U/lHyMG1EElWW4Ksum2gterl/3bxEd6nrAaZ0NXJPi3Ofx5hHp09W"));
			
			// pswd = testing
			userRepo.save(new User("Test2", "$2a$10$U/lHyMG1EElWW4Ksum2gterl/3bxEd6nrAaZ0NXJPi3Ofx5hHp09W"));
			
			// pswd = hallinto
			userRepo.save(new User("admin", "$2a$10$JosU00F6aKVcsPCyZpPRwOUWlhaGz97mGv71mhtFY5vgtMiNHppu."));
			
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
			Movie lit = new Movie("Lost In Translation", 2003, 101);
			Movie mov = new Movie("Plan 9 From Outer Space", 1959, 79);
			Movie mov2 = new Movie("Forrest Gump", 1994, 144);
			Movie mov3 = new Movie("Into The Wild", 2007, 148);
			
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
			rateRepo.save(new Rating(user1, mov, 1, "So bad"));
			rateRepo.save(new Rating(user2, mov2, 4, "Awsum"));
			rateRepo.save(new Rating(user2, mov, 4, "Oh ye"));
			rateRepo.save(new Rating(user2, lit, 4, "Awsum"));
			rateRepo.save(new Rating(user1, nightmareBefore, 5, "Awsum"));

			rateRepo.save(new Rating(user2, nightmareBefore, 5, "Awsum"));
															
	//		userRepo.deleteById((long) 1); // DELETE ALL RATINGS FROM USER
	//		movieRepo.deleteById((long) 1); // DELETE ALL RATINGS FROM MOVIE
			
			log.info("SYSTEM UP AND RUNNING!");
		};
	}
}
