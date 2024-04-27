package com.firstTry.demo.user;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.firstTry.demo.ResponseHandler.copy.ApiResponse;
import com.firstTry.demo.user.*;


@RestController
public class UserController {
	
	private UserRepository userRepo;
	
	
	public UserController(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}

   @Autowired	
   private UserService userService;
	
	@PostMapping("/create-user")
	public ResponseEntity<UserDto> create(@Valid @RequestBody UserDto userDto){
		System.out.println("Hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii............................");
		UserDto createdUser = userService.createUser(userDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
	}
	
	
	@GetMapping("/get-all-user")
	public ResponseEntity<List<UserDto>> getallusers(){
		List<UserDto> allUsers = userService.getAllUsers();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(allUsers);
	}
	
	@GetMapping("/get-user")
	public ResponseEntity<UserDto> getUser(@RequestBody UserDto userDto){
		int id = userDto.getId();
		
		UserDto user= userService.getUser(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(user);
	}
	
	@PutMapping("/update-user")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto){
		int id = userDto.getId();
		UserDto updatedUser = userService.updateUser(userDto, id);
		return ResponseEntity.ok(updatedUser);
	}
	
	@GetMapping("/hello")
	public String getusername()
	{
		System.out.println("Geting---------------------------");
		userService.createUser(new UserDto());
		return "ABC";
	}
	
	@DeleteMapping("/delte-user")
	public ResponseEntity<?> deleteUser(@RequestBody UserDto userDto){
		int id = userDto.getId();
		userService.deleteUser(id);
		return new ResponseEntity(Map.of("message","user deleted sucessfully"),HttpStatus.OK);
	}
}

