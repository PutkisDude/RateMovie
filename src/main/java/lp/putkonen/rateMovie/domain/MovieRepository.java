package lp.putkonen.rateMovie.domain;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	
	
	// Custom Query for avg and count functions
	
	@Query(value = "SELECT ID, TITLE, LENGTH, YEAR, AVG(CAST(rating AS FLOAT)) AS AVG_RATING, COUNT(RATING) AS RATE_COUNT "
			+ "FROM MOVIE "
			+ "INNER JOIN RATING "
			+ "ON movie.id = rating.movie_id "
			+ "GROUP BY id", 
			nativeQuery = true)
	List<Movie> updateRatings();

}
