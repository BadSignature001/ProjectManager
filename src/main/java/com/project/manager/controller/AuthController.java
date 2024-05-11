package com.project.manager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.project.manager.config.JwtProvider;
import com.project.manager.modal.User;
import com.project.manager.repository.UserRepository;
import com.project.manager.request.LoginRequest;
import com.project.manager.response.AuthResponse;
import com.project.manager.service.CustomUserDetailsImpl;
import com.project.manager.service.SubscriptionService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private JwtProvider jwtProvider;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private CustomUserDetailsImpl customUserDetailsImpl;
	
	@Autowired
	private SubscriptionService subscriptionService ;

	@PostMapping("/signup")
	public ResponseEntity<AuthResponse> createUserHandler(@RequestBody User user) throws Exception {

		User isUserExist = userRepository.findByEmail(user.getEmail());

		if (isUserExist != null) {
			throw new Exception("Email already Exist");

		}

		User createUser = new User();

		createUser.setFullName(user.getFullName());
		createUser.setEmail(user.getEmail());
		createUser.setPassword(passwordEncoder.encode(user.getPassword()));

		User savedUser = userRepository.save(createUser);
		
		
		subscriptionService.createSubscription(savedUser) ;

		Authentication authentication = new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = JwtProvider.generateToken(authentication);

		AuthResponse res = new AuthResponse();
		res.setJwt(jwt);
		res.setMessage("signup success");

		return new ResponseEntity<>(res, HttpStatus.CREATED);

	}

	@PostMapping("/signin")
	public ResponseEntity<AuthResponse> signin(@RequestBody LoginRequest loginRequest) {

		String username = loginRequest.getEmail();
		String password = loginRequest.getPassword();

		Authentication authentication = authenticate(username, password);
		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = JwtProvider.generateToken(authentication);

		AuthResponse res = new AuthResponse();
		res.setJwt(jwt);
		res.setMessage("signin success");

		return new ResponseEntity<>(res, HttpStatus.CREATED);
	}

	private Authentication authenticate(String username, String password) {
		UserDetails userDetails = customUserDetailsImpl.loadUserByUsername(username) ;
		
		if(userDetails==null)
		{
			throw new BadCredentialsException("invalid username") ;
			
		}
		if(!passwordEncoder.matches(password, userDetails.getPassword()))
		{
			throw new BadCredentialsException("invalid password") ;
		}
		
		return new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
	}

}
