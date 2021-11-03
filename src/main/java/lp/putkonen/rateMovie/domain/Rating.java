package lp.putkonen.rateMovie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {

	@EmbeddedId
	MovieRatingKey id;
	private int rating;
	private String comment;
	
	@ManyToMany
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	List<User> userReviews = new ArrayList<>();

	@ManyToMany
	@MapsId("movie_id")
	List<Movie> movies = new ArrayList<>();

	

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

	public List<User> getUsers() {
		return userReviews;
	}

	public void setUsers(List<User> users) {
		this.userReviews = users;
	}

	public MovieRatingKey getId() {
		return id;
	}

	public void setId(MovieRatingKey id) {
		this.id = id;
	}

		
}
