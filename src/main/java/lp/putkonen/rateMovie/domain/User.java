package lp.putkonen.rateMovie.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "User")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long userId;
	private String name;
	private String password;
	
    @OneToMany(mappedBy = "rating")
    private List<MovieRating> movieRatings = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "rating")
	private List<Rating> ratings;
		
	public User() {
		
	}
	
	public User(String name, String password) {
		this.name = name;
		this.password = password;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", password=" + password + "]";
	}	
}
