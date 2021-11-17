package lp.putkonen.rateMovie.domain;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long> {
	
	public List<Movie> findByTitleContainingIgnoreCase(String title);
	
	// Custom Query for avg and count
	
	@Query(value = "SELECT ID, TITLE, LENGTH, YEAR, AVG(CAST(points AS FLOAT)) AS AVG_RATING, COUNT(POINTS) AS RATE_COUNT "
			+ "FROM MOVIE "
			+ "INNER JOIN RATING "
			+ "ON movie.id = rating.movie_id "
			+ "GROUP BY id", 
			nativeQuery = true)
	List<Movie> updateRatings();
	
	
	public Movie findByTitle(String title);

}
