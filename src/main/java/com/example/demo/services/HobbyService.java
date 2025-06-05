package com.example.demo.services;

import com.example.demo.DTO.HobbyDTO;
import com.example.demo.DTO.PassportDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface HobbyService {
    HobbyDTO create(HobbyDTO hobby);
    UserDTO findById(Long id);
    List<UserDTO> getAll();
    UserDTO update(Long id, UserDTO user);
    void delete(Long id);
}
