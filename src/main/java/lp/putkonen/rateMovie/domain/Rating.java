package lp.putkonen.rateMovie.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Rating")
public class Rating {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long ratingId;
	private double rating;
	private String comment;
	
    @OneToMany(mappedBy = "rating", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<MovieRating> movieRatings;
	
	
	public Rating() {
		
	}
	
	public Rating(double rating, String comment) {
		this.rating = rating;
		this.comment = comment;
	}
	
	public Long getRatingId() {
		return ratingId;
	}

	public void setRatingId(Long ratingId) {
		this.ratingId = ratingId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public List<MovieRating> getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(List<MovieRating> movieRatings) {
		this.movieRatings = movieRatings;
	}

	@Override
	public String toString() {
		return "Rating [ratingId=" + ratingId + ", rating=" + rating + ", comment=" + comment + "]";
	}
	
}
