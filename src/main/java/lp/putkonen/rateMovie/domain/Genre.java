package lp.putkonen.rateMovie.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long genreId;
	
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "genre")
	private List<Movie> movies;
	
	
	public Genre() {
		this.name = null;
	}

	public Genre(String name) {
		super();
		this.name = name;
	}
	public long getGenreId() {
		return genreId;
	}
	public void setGenreId(long genreId) {
		this.genreId = genreId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Genre [genreId=" + genreId + ", name=" + name + "]";
	}	
}
