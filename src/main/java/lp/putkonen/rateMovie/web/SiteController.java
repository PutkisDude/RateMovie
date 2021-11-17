package lp.putkonen.rateMovie.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SiteController {

    @RequestMapping("/login")
	public String login() {
		return "login";
	}    
}
