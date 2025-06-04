package com.example.demo.services.impl;

import com.example.demo.DTO.PassportDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.PassportService;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

    @Override
    public PassportDTO create(PassportDTO passport) {
        return null;
    }

    @Override
    public PassportDTO findById(Long id) {
        return null;
    }

    @Override
    public List<PassportDTO> getAll() {
        return List.of();
    }

    @Override
    public PassportDTO update(Long id, PassportDTO passport) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
