package lp.putkonen.rateMovie.domain;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>{

	public Boolean existsByMovieAndUser(Movie movie, Optional<User> user);

	public Rating findByMovieAndUser(Movie movie, Optional<User> user);
}
