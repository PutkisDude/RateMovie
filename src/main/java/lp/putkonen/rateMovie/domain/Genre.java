package lp.putkonen.rateMovie.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="Genre")
@JsonIgnoreProperties(value = { "moviesGen" })
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="movieGenres", fetch = FetchType.LAZY)
	private List<Movie> moviesGen = new ArrayList<Movie>();
	
	public void moviesGen(Movie movie) {
		moviesGen.add(movie);
	}
	
	public Genre() {
	}

	public Genre(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Genre [id=" + id + ", name=" + name + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void addMovie(Movie movie) {
		moviesGen.add(movie);
	}
	
	public void removeMovie(Movie movie) {
		moviesGen.remove(movie);
	}

	public List<Movie> getMoviesGen() {
		return moviesGen;
	}

	public void setMoviesGen(List<Movie> moviesGen) {
		this.moviesGen = moviesGen;
	}	
}
