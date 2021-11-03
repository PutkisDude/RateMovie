package lp.putkonen.rateMovie.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class MovieRatingKey implements Serializable{

	@Column(name = "movie_id")
	Long movieId;
	@Column(name = "user_id")
	Long userId;
	
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	@Override
	public int hashCode() {
		return Objects.hash(movieId, userId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MovieRatingKey other = (MovieRatingKey) obj;
		return Objects.equals(movieId, other.movieId) && Objects.equals(userId, other.userId);
	}
}
