package lp.putkonen.rateMovie.domain;

import org.springframework.data.repository.CrudRepository;

public interface RatingRepository extends CrudRepository<Rating, Long>{

	public Boolean existsByMovieAndUser(Movie movie, User user);

}
