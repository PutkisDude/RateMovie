package lp.putkonen.rateMovie.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name="Movie")
@JsonIgnoreProperties(value = { "ratings"})
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long movieId;	
	private String title;
	private int year;
	private int length;
	private double avgRating;
	private int rateCount;
		
	@ManyToMany
	@JoinTable(
			name="movie_genres",
	joinColumns= @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "genre_id"))
	@JsonIgnoreProperties("moviesGen")
	private List<Genre> movieGenres = new ArrayList<Genre>();
	
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "movie")
	private List<Rating> ratings;
	
	
	public Movie() {
	}
	
	public Movie(String title, int year, int length) {
		this.title = title;
		this.year = year;
		this.length = length;
	}
	
	public void addGenre(Genre genre) {
		movieGenres.add(genre);
	}
	
	public void removeGenre(Genre genre) {
		movieGenres.remove(genre);
	}
		
	public Long getMovieId() {
		return movieId;
	}
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getLength() {
		return length;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public int getRateCount() {
		return rateCount;
	}

	public void setRateCount(int rateCount) {
		this.rateCount = rateCount;
	}

	public List<Genre> getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(List<Genre> movieGenres) {
		this.movieGenres = movieGenres;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public void setLength(int length) throws Exception {
		this.length = length;
	}
	
	public String getLengthInHoursAndMinutes() {
		String len = "";
		if(this.length > 59) {
			len += this.length/60  +"h";
		}
		len += " " + this.length%60 + "m";
		return len;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", year=" + year + ", length=" + length
				+ ", avgRating=" + avgRating + ", rateCount=" + rateCount + "]";
	}
	
}
