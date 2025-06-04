package com.example.demo.services;

import com.example.demo.DTO.PassportDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface PassportService {
    PassportDTO create(PassportDTO passport);
    PassportDTO findById(Long id);
    List<PassportDTO> getAll();
    PassportDTO update(Long id, PassportDTO passport);
    void delete(Long id);
}
