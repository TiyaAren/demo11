package com.example.demo.services;

import com.example.demo.DTO.PassportDTO;

import java.util.List;

public interface PassportService {
    PassportDTO create(PassportDTO DTO);
    PassportDTO findById(Long id);
    List<PassportDTO> getAll();
    PassportDTO update(Long id, PassportDTO passport);
    void delete(Long id);
}
