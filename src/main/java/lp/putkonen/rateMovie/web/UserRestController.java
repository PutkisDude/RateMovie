package lp.putkonen.rateMovie.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

public class UserRestController {
	
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/api/users/{id}")
	public @ResponseBody Optional<User> api(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
}
