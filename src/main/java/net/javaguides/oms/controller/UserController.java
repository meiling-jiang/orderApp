package net.javaguides.oms.controller;

import lombok.AllArgsConstructor;
import net.javaguides.oms.dto.UserDto;
import net.javaguides.oms.service.user.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:4200") // Allow requests from Angular frontend
public class UserController {

    private UserService userService;

    // Build Add User Rest API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Build Get User Rest API
    @GetMapping("{email}")
    public ResponseEntity<UserDto> getUserByEmail(@RequestParam("email") String userEmail) {
        UserDto userDto = userService.getUserByEmail(userEmail);
        return ResponseEntity.ok(userDto);
    }
}
