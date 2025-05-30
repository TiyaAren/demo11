package com.example.demo.DTO;

import com.example.demo.entity.Account;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.Passport;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Set;

public record UserDTO(
        @NotNull
        @Size(min = 2, max = 50)
        String name,
        @NotNull
        @Size(min = 18, max = 100)
        int age,
        @NotNull
        Passport passport,
        List<AccountDTO> accounts,
        Set<String> hobbies) {
}
