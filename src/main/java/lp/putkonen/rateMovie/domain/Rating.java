package lp.putkonen.rateMovie.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ratingId;
	
	
//	private Movie movie;
	
	
	private int rating;
	
	public Rating(Movie movie, int rating) {
//		this.movie = movie;
		this.rating = rating;
	}
	
	public Rating() {
		
	}
	
	public long getRatingId() {
		return ratingId;
	}
	public void setRatingId(long ratingId) {
		this.ratingId = ratingId;
	}

	/*
	 * public User getUser() { return user; } public void setUser(User user) {
	 * this.user = user; }
	 */
	/*
	 * public Movie getMovie() { return movie; } public void setMovie(Movie movie) {
	 * this.movie = movie; }
	 */
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
}
