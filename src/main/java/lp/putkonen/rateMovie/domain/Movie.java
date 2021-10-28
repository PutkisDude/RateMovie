package lp.putkonen.rateMovie.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long movieId;
	
	@ManyToOne
	@JoinColumn(name = "genreId")
	@JsonIgnoreProperties("genres")
	private Genre genre;

	
	private String title;

	
	private int year;
	private int length;
	
	public Movie() {
		this.title = null;
		this.genre = null;
		this.year = 0;
		this.length = 0;
	}
	
	public Movie(String title, Genre genre, int year, int length) {
		this.title = title;
		this.genre = genre;
		this.year = year;
		this.length = length;
	}
	
	public long getMovieId() {
		return movieId;
	}
	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
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
	public void setLength(int length) {
		this.length = length;
	}
}
