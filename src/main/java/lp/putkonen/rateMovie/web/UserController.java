package lp.putkonen.rateMovie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import lp.putkonen.rateMovie.domain.RatingRepository;
import lp.putkonen.rateMovie.domain.UserRepository;

@Controller
public class UserController {

	@Autowired
	RatingRepository rateRepository;
	
	@Autowired
	UserRepository userRepository;
		
	
	@GetMapping("/users")
	public String userPage(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")  
	@GetMapping("/deleteuser/{id}")
	public String remoteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
		return "redirect:/users";
	}
	

	
}
