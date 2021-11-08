package lp.putkonen.rateMovie.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
@Table(name="Genre")
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy="movieGenres", cascade = {CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.MERGE,
			CascadeType.REFRESH,
			CascadeType.REMOVE
	})
	private List<Movie> moviesGen = new ArrayList<>();
	
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

	public List<Movie> getMoviesGen() {
		return moviesGen;
	}

	public void setMoviesGen(List<Movie> moviesGen) {
		this.moviesGen = moviesGen;
	}	
}
