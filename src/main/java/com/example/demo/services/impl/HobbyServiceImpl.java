package com.example.demo.services.impl;

import com.example.demo.DTO.HobbyDTO;
import com.example.demo.entity.Hobby;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor

public class HobbyServiceImpl implements HobbyService {
    private final HobbyRepository hobbyRepository;

    @Override
    public HobbyDTO create(HobbyDTO hobbydto) {
        return new HobbyDTO(hobbyRepository.save(Hobby.builder().type(hobbydto.type()).build()).getType());
    }

    @Override
    public HobbyDTO findById(Long id) {
        return hobbyRepository.findById(id)
                .map(hobby -> new HobbyDTO(hobby.getType()))
                .orElseThrow(() -> new NoSuchElementException("Hobby not found"));
    }

    @Override
    public List<HobbyDTO> getAll() {
        return hobbyRepository.findAll().stream()
                .map(hobby -> new HobbyDTO(hobby.getType()))
                .toList();
    }

    @Override
    public HobbyDTO update(Long id, HobbyDTO hobbyDTO) {
        Hobby existHobby = hobbyRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Hobby not found"));
        existHobby.setType(hobbyDTO.type());

        return new HobbyDTO(hobbyRepository.save(existHobby).getType());
    }

    @Override
    public void delete(Long id) {
        hobbyRepository.deleteById(id);
    }
}
