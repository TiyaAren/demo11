package com.example.demo.controllers;

import com.example.demo.DTO.HobbyDTO;
import com.example.demo.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/hobby")
public class HobbyController {
    private final HobbyService hobbyService;

    @GetMapping
    public ResponseEntity<List<HobbyDTO>> getHobbies() {
        return ResponseEntity.ok().body(hobbyService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<HobbyDTO> getHobbyById(@PathVariable Long id) {
        return ResponseEntity.ok().body(hobbyService.findById(id));
    }

    @PostMapping
    public ResponseEntity<HobbyDTO> createHobby(@RequestBody HobbyDTO hobbyDTO) {
        return ResponseEntity.ok().body(hobbyService.create(hobbyDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<HobbyDTO> updateHobby(@PathVariable Long id, @RequestBody HobbyDTO hobbyDTO) {
        return ResponseEntity.ok().body(hobbyService.update(id, hobbyDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HobbyDTO> deleteHobby(@PathVariable Long id) {
        hobbyService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
