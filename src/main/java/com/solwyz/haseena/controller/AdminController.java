//package com.solwyz.haseena.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.solwyz.haseena.entity.User;
//import com.solwyz.haseena.pojo.response.ApiResponse;
//import com.solwyz.haseena.service.UserService;
//
//@RestController
//@RequestMapping(value = "/api/admin")
//public class AdminController {
//
//	@Autowired
//	private UserService userService;
//
//	@PostMapping(value = "/create")
//	public ResponseEntity<User> createUser(@RequestBody User user) {
//		User createdUser = userService.createUser(user);
//		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
//	}
//
//	@GetMapping("/all")
//	public ResponseEntity<ApiResponse<List<User>>> getAllUsers() {
//		List<User> users = userService.getAllUsers();
//		ApiResponse<List<User>> response = new ApiResponse<>("success", users);
//		return ResponseEntity.ok(response);
//	}
//
//	@GetMapping(value = "/{id}")
//	public ResponseEntity<User> getUserById(@PathVariable Long id) {
//		User user = userService.getUserById(id);
//		return ResponseEntity.ok(user);
//	}
//
//	@PutMapping(value = "/update/{id}")
//	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user) {
//		User updated = userService.updateUser(id, user);
//		return ResponseEntity.ok(updated);
//	}
//
//	@DeleteMapping(value = "/delete/{id}")
//	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
//		userService.deleteUser(id);
//		return ResponseEntity.ok("User deleted successfully");
//	}
//
//}
