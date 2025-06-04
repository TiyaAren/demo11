package com.example.demo.services.impl;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.HobbyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HobbyServiceImpl implements HobbyService {
    private final UserRepository userRepository;
    private final HobbyRepository hobbyRepository;

    @Override
    public UserDTO create(UserDTO user) {
        Set<Hobby> hobbies = user.hobbies().stream()
                .map(name -> hobbyRepository.findByName(name)
                        .orElseGet(() -> hobbyRepository.save(Hobby.builder().type(name).build()))).collect(Collectors.toSet());
        User userToSave = UserMapper.toEntity(user, List.copyOf(hobbies));
        return UserMapper.toDto(userRepository.save(userToSave));
    }

    @Override
    public UserDTO findById(Long id) {
        return null;
    }

    @Override
    public List<UserDTO> getAll() {
        return List.of();
    }

    @Override
    public UserDTO update(Long id, UserDTO user) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
