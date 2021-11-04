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


@Entity
@Table(name="Movie")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long movieId;	
	private String title;
	private int year;
	private int length;
	
	@ManyToMany
	@JoinTable(
			name="movie_genres",
	joinColumns= @JoinColumn(name = "movie_id"),
	inverseJoinColumns = @JoinColumn(name = "genre_id"))
	private List<Genre> movieGenres = new ArrayList<>();
	
    
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
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

	public List<Genre> getMovieGenres() {
		return movieGenres;
	}

	public void setMovieGenres(List<Genre> movieGenres) {
		this.movieGenres = movieGenres;
	}

}
