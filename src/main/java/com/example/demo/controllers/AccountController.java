package com.example.demo.controllers;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.PassportDTO;
import com.example.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> getAccounts() {
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok().body(accountService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountService.create(accountDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountService.update(id, accountDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
