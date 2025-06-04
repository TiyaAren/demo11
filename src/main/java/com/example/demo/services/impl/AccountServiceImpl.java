package com.example.demo.services.impl;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Account;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final AccountRepository accountRepository;


    @Override
    public AccountDTO create(AccountDTO user) {
        return null;
    }

    @Override
    public AccountDTO findById(Long id) {
        return null;
    }

    @Override
    public List<AccountDTO> getAll() {
        return List.of();
    }

    @Override
    public AccountDTO update(Long id, AccountDTO account) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
