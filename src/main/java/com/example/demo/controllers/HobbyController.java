package com.example.demo.controllers;

import com.example.demo.DTO.HobbyDTO;
import com.example.demo.services.HobbyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hobby")
@Tag(name = "Hobby API", description = "CRUD операции для Hobby")
public class HobbyController {
    private final HobbyService hobbyService;
    @Operation(summary = "Find all Hobby", tags = {"Hobby"}, description = "Find all Hobbies for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobbies found successfully")
    })
    @GetMapping
    public ResponseEntity<List<HobbyDTO>> getHobbies() {
        return ResponseEntity.ok().body(hobbyService.getAll());
    }
    
    @Operation(summary = "Find Hobby", tags = {"Hobby"}, description = "Find Hobby by id", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was found successfully"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @GetMapping("/{id}")
    public ResponseEntity<HobbyDTO> getHobbyById(@PathVariable Long id) {
        return ResponseEntity.ok().body(hobbyService.findById(id));
    }
    
    @Operation(summary = "Create Hobby", tags = {"Hobby"}, description = "Create new Hobby for users", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was created successfully")
    })
    @PostMapping
    public ResponseEntity<HobbyDTO> createHobby(@RequestBody HobbyDTO hobbyDTO) {
        return ResponseEntity.ok().body(hobbyService.create(hobbyDTO));
    }

    @Operation(summary = "Update Hobby", tags = {"Hobby"}, description = "Update Hobby by id", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was updated successfully"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @PutMapping("/{id}")
    public ResponseEntity<HobbyDTO> updateHobby(@PathVariable Long id, @RequestBody HobbyDTO hobbyDTO) {
        return ResponseEntity.ok().body(hobbyService.update(id, hobbyDTO));
    }

    @Operation(summary = "Delete Hobby", tags = {"Hobby"}, description = "Delete Hobby by id", responses = {
            @ApiResponse(responseCode = "200", description = "Hobby was deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Hobby not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<HobbyDTO> deleteHobby(@PathVariable Long id) {
        hobbyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
