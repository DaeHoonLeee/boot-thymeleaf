package idu.cs.controller;

import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import idu.cs.domain.User;
import idu.cs.repository.UserRepository;

@Controller
public class HomeController {
	@Autowired UserRepository userRepo;
	
	@GetMapping("/test")
	public String home(Model model) {
		model.addAttribute("test", "인덕컴소");
		model.addAttribute("egy", "유응구");
		return "index";
	}
	@GetMapping("/users")
	public String getAllUser(Model model) {
		model.addAttribute("users", userRepo.findAll());
		return "userlist";
		
		
	}
	/*
	@GetMapping("/users/{id}")
	public String getUserById(@PathVariable(value = "id") Long userId, 
			Model model) throws ResourceNotFoundException {
		Optional<User> user = userRepo.findById(userId);
		model.addAttribute("id", "" + userId);
		model.addAttribute("name", user.getName());
		model.addAttribute("company", user.getCompany());
		return "user";
		
		
	}
	
	*/
	@GetMapping("/welcome")
	public String loadWelcome(Model model) {
		return "welcome";
		
		
	}
	
	
	
	
	@GetMapping("/register")
	public String loadRegForm(Model model) {
		return "regForm";
		
		
	}
	
	@PostMapping("/create")
	public String createUser(@Valid @RequestBody User user, Model model) {
	userRepo.save(user);
	model.addAttribute("users", userRepo.findAll());
	return "redirect:/users";
}

}
