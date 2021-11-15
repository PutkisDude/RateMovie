package lp.putkonen.rateMovie.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.User;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class UserController {

	@Autowired
	RatingRepository rateRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	/*
	 * // MAKE USER PAGE FROM findByUsername...
	 * 
	 * @GetMapping("/user/{name}") public @ResponseBody Optional<User>
	 * userPage(@PathVariable("name") String username){ String search =
	 * username.trim(); return
	 * Optional.ofNullable(userRepo.findByUsernameIgnoreCase(search));
	 * 
	 * }
	 */
	
	@GetMapping("/users")
	public String userPage(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
	
	@GetMapping("/deleteuser/{id}")
	public String remoteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return "redirect:/users";
	}
	
	
	@GetMapping("/api/user/{id}")
	public @ResponseBody Optional<User> api(@PathVariable("id") Long id) {
		return userRepository.findById(id);
	}
	
}
