package com.example.demo.services;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface AccountService {
    AccountDTO create(AccountDTO user);
    AccountDTO findById(Long id);
    List<AccountDTO> getAll();
    AccountDTO update(Long id, AccountDTO account);
    void delete(Long id);
}
