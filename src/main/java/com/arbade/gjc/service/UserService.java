package com.arbade.gjc.service;


import com.arbade.gjc.mapper.UserMapper;
import com.arbade.gjc.model.dto.request.UserRequestDto;
import com.arbade.gjc.model.dto.response.UserResponseDto;
import com.arbade.gjc.model.entity.User;
import com.arbade.gjc.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Slf4j
@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Autowired
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDto createUser(UserRequestDto userRequestDto) {

        long globalRank = userRepository.count() + 1;
        long localRank = userRepository.countAllByCountry(userRequestDto.getCountry()) + 1;
        User user = userMapper.map(userRequestDto);
        user.set_id(UUID.randomUUID());
        user.setGlobalRank(globalRank);
        user.setLocalRank(localRank);
        User savedUser = userRepository.save(user);
        return userMapper.mapToDto(savedUser);
    }

    public UserResponseDto getByUserId(UUID id) throws Exception {
        User user = userRepository.findById(id).orElseThrow(() -> new Exception("Not Found"));
        return userMapper.mapToDto(user);
    }

    public void deleteUserById(UUID id) {
        userRepository.deleteById(id);
    }

    public void deleteAllUser() {
        userRepository.deleteAll();
    }


}
