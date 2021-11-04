package lp.putkonen.rateMovie.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "Rating")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ratingId;
	private int rating;
	private String comment;
	
    @ManyToOne 
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties ("users") 
    private User user;
    
    @ManyToOne 
    @JoinColumn(name = "movie_id")
    @JsonIgnoreProperties ("movies") 
    private Movie movie;
	
    
	public Rating() {
		
	}
	
	public Rating(User user, Movie movie, int rating, String comment) {
		this.movie = movie;
		this.user = user;
		this.rating = rating;
		this.comment = comment;
	}
	
	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", comment=" + comment + ", user=" + user
				+ ", movie=" + movie + "]";
	}
	
}
