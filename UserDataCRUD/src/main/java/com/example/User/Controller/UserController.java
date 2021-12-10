package com.example.User.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.User.Model.User;
import com.example.User.Repo.UserRepo;
import com.example.UserException.ResourseNotFoundException;

@RestController
@RequestMapping("user_API")
public class UserController {

	@Autowired
	private UserRepo userRepo;

	// get list of users rest-api
	@CrossOrigin
	@GetMapping("users")
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	// create user rest-api
	@CrossOrigin
	@PostMapping("users")
	public User createUser(@RequestBody User eve) {
		return userRepo.save(eve);

	}

	// get user by id rest-api
	@CrossOrigin
	@GetMapping("users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("User does not exist with this ID number : " + id));
		return ResponseEntity.ok(user);

	}

	// update user rest-api
	@CrossOrigin
	@PutMapping("users/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails) {

		User user = userRepo.findById(id)
				.orElseThrow(() -> new ResourseNotFoundException("User does not exist with this ID number : " + id));

		user.setFirstName(userDetails.getFirstName());
		user.setLastName(userDetails.getLastName());
		user.setMailId(userDetails.getMailId());
		user.setPhone(userDetails.getPhone());
		

		User updatedUser = userRepo.save(user);
		return ResponseEntity.ok(updatedUser);
	}
	
	//delete rest-api
	

	@GetMapping("check")
	public String working() {
		return "Working";
	}

}
