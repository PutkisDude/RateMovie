package lp.putkonen.rateMovie.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.Rating;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class UserController {

	@Autowired
	RatingRepository rateRepo;
	
	@Autowired
	UserRepository userRepo;
	
	
	// MAKE USER PAGE FROM findByUsername...
	@GetMapping("/user/{name}")
	public @ResponseBody Optional<User> userPage(@PathVariable("name") String username){
		String search = username.trim();
		return Optional.ofNullable(userRepo.findByUsernameIgnoreCase(search));
		
	}
	
	
	@GetMapping("/api/user/{id}")
	public @ResponseBody Optional<User> api(@PathVariable("id") Long id) {
		return userRepo.findById(id);
	}
	
}
