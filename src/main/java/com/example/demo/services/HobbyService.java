package com.example.demo.services;

import com.example.demo.DTO.HobbyDTO;

import java.util.List;

public interface HobbyService {
    HobbyDTO create(HobbyDTO hobby);
    HobbyDTO findById(Long id);
    List<HobbyDTO> getAll();
    HobbyDTO update(Long id, HobbyDTO user);
    void delete(Long id);
}
