package com.arbade.gjc.repository;

import java.util.Optional;

import com.arbade.gjc.model.dto.request.UserRequestDto;
import com.arbade.gjc.model.dto.response.UserResponseDto;
import com.arbade.gjc.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    long countAllByCountry(String country);

    UserResponseDto findUserByUuid(String id);

    User deleteUserByUuid(String id);

}