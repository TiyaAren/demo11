package com.example.demo.controllers;

import com.example.demo.DTO.UserDTO;
import com.example.demo.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Operation(summary = "Find all User", tags = {"User"}, description = "Find all Hobbies for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobbies found successfully")
    })
    @GetMapping
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok().body(userService.getAll());
    }

    @Operation(summary = "Find User", tags = {"User"}, description = "Find User by id", responses = {
            @ApiResponse(responseCode = "200", description = "User was found successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @Operation(summary = "Create User", tags = {"User"}, description = "Create new User for users", responses = {
            @ApiResponse(responseCode = "200", description = "User was created successfully")
    })
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.create(userDTO));
    }

    @Operation(summary = "Update User", tags = {"User"}, description = "Update User by id", responses = {
            @ApiResponse(responseCode = "200", description = "User was updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        return ResponseEntity.ok().body(userService.update(id, userDTO));
    }

    @Operation(summary = "Delete User", tags = {"User"}, description = "Delete User by id", responses = {
            @ApiResponse(responseCode = "200", description = "User was deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
