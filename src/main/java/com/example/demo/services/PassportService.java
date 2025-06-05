package com.example.demo.services;

import com.example.demo.DTO.PassportDTO;
import com.example.demo.DTO.UserDTO;

import java.util.List;

public interface PassportService {
    PassportDTO create(PassportDTO DTO);
    PassportDTO getById(Long id);
    List<PassportDTO> getAll();
    PassportDTO update(Long id, PassportDTO passport);
    void delete(Long id);
}
