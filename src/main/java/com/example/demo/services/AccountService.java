package com.example.demo.services;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface AccountService {
    AccountDTO create(AccountDTO accountDTO);
    AccountDTO findById(Long id);
    List<AccountDTO> getAll();
    AccountDTO update(Long id, AccountDTO accountDTO);
    void delete(Long id);
}
