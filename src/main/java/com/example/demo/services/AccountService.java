package com.example.demo.services;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface AccountService {
    AccountDTO create(UserDTO user);
    AccountDTO findById(Long id);
    List<AccountDTO> getAll();
    AccountDTO update(Long id, UserDTO userDTO);
    void delete(Long id);
}
