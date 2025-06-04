package com.example.demo.services.impl;

import com.example.demo.DTO.UserDTO;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.HobbyRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
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
        return userRepository.findById(id).map(UserMapper::toDto).orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @Override
    public List<UserDTO> getAll() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }

    @Override
    public UserDTO update(Long id, UserDTO user) {

        User existUser = userRepository.findById(id).orElseThrow(() -> new NoSuchElementException("User not found"));
        existUser.setName(user.name());
        existUser.setAge(user.age());
        return UserMapper.toDto(userRepository.save(existUser));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
