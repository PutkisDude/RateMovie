package lp.putkonen.rateMovie;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;


import lp.putkonen.rateMovie.domain.GenreRepository;
import lp.putkonen.rateMovie.domain.MovieRepository;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.UserRepository;

@SpringBootTest
class RateMovieApplicationTests {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	@Autowired
	MovieRepository movieRepository;

	@Autowired
	RatingRepository ratingRepository;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	public void userContextLoads() {
		assertThat(userRepository).isNotNull();
	}
	
	@Test
	public void movieContextLoads() {
		assertThat(movieRepository).isNotNull();
	}

	@Test
	public void genreContextLoads() {
		assertThat(genreRepository).isNotNull();
	}

	@Test
	public void ratingContextLoads() {
		assertThat(ratingRepository).isNotNull();
	}

}
