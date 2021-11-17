package lp.putkonen.rateMovie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;


import lp.putkonen.rateMovie.domain.Movie;
import lp.putkonen.rateMovie.domain.MovieRepository;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class MovieTest {

	@Autowired
	private MovieRepository movieRepository;
	
	@Test
	public void createNewMovie() {
		Movie movie = new Movie("test", 2021, 120);
		movieRepository.save(movie);
		assertThat(movie.getMovieId()).isNotNull();
	}
	
	@Test
	public void deleteMovie() {
		Movie movie = new Movie("test", 2021, 120);
		movieRepository.save(movie);
		assertThat(!movieRepository.findById(movie.getMovieId()).isEmpty()); // ! = is not empty so movie exist in database
		movieRepository.delete(movie);
		assertThat(movieRepository.findById(movie.getMovieId()).isEmpty()); // is empty, movie doesn't exist
	}
	
	@Test
	public void hasValues() {
		Movie movie = movieRepository.save(new Movie("testing", 2015, 120));
		
		assertThat(movie).hasFieldOrPropertyWithValue("title", "testing");
		assertThat(movie).hasFieldOrPropertyWithValue("year", 2015);
		assertThat(movie).hasFieldOrPropertyWithValue("length", 120);		
	}
	
}
