package com.example.demo.controllers;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.services.AccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    @Operation(summary = "Find all Accounts", tags = {"Account"}, description = "Find all Accounts for users", responses = {
            @ApiResponse(responseCode = "200", description = "Accounts found successfully")
    })

    public ResponseEntity<List<AccountDTO>> getAccounts() {
        return ResponseEntity.ok().body(accountService.getAll());
    }

    @Operation(summary = "Find Account", tags = {"Account"}, description = "Find Account by id", responses = {
            @ApiResponse(responseCode = "200", description = "Account was found successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok().body(accountService.findById(id));
    }

    @Operation(summary = "Create Account", tags = {"Account"}, description = "Create new Account for users", responses = {
            @ApiResponse(responseCode = "200", description = "Account was created successfully")
    })
    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountService.create(accountDTO));
    }

    @Operation(summary = "Update Account", tags = {"Account"}, description = "Update Account by id", responses = {
            @ApiResponse(responseCode = "200", description = "Account was updated successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateAccount(@PathVariable Long id, @RequestBody AccountDTO accountDTO) {
        return ResponseEntity.ok().body(accountService.update(id, accountDTO));
    }

    @Operation(summary = "Delete Account", tags = {"Account"}, description = "Delete Account by id", responses = {
            @ApiResponse(responseCode = "200", description = "Account was deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Account not found")})
    @DeleteMapping("/{id}")
    public ResponseEntity<AccountDTO> deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
