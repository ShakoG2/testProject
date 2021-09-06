package com.example.demo.user.controller;


import com.example.demo.user.repository.UserRepository;
import com.example.demo.model.User;
import com.example.demo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3001")
public class UserController {


	private final UserService userService;
	private final UserRepository userRepository;

	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public User save(@RequestBody User user) {
//		return userService.register(user);
//		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//		User user1 = new User();
//		//user1.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		user1.setLastName(user.getLastName());
//		user1.setEmail(user.getEmail());
//		user1.setUserName(user.getUserName());
//		user1.setFirstName(user.getFirstName());
//		return userRepository.save(user1);

		return userRepository.save(user);
	}

//	@GetMapping("{userId}")
//	public User get(@PathVariable Long userId) throws NotFoundException {
//		return userService.get(userId);
//	}
}
