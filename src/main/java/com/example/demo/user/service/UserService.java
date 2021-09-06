package com.example.demo.user.service;

import com.example.demo.model.AppUsers;
import com.example.demo.model.AuthGroup;
import com.example.demo.model.AuthGroupRepository;
import com.example.demo.model.User;
import com.example.demo.user.repository.UserRepository;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {

	private final UserRepository userRepository;
	private final AuthGroupRepository authGroupRepository;


//	public User register(User user) {
//		if (user.getPassword() == null ||
//				user.getEmail() == null ||
//				user.getLastName() == null ||
//				user.getFirstName() == null
//		) {
//			throw new RuntimeException("All fields must be filled");
//		}
//		if (userRepository.findByEmail(user.getEmail()) != null)
//			throw new RuntimeException("Email " + user.getEmail() + " already used");
//		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		return userRepository.save(user);
//	}
//
//	public User get(Long id) throws NotFoundException {
//		return userRepository.findById(id).orElseThrow(() -> new NotFoundException("User not found"));
//	}

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(s);
		if (user == null) {
			throw new UsernameNotFoundException("UserName not found");
		}
		List<AuthGroup> authGroups = authGroupRepository.findAllByUserName(s);
		return new AppUsers(user, authGroups);
	}
}
