package com.arbade.gjc.controller;

import com.arbade.gjc.model.dto.request.UserRequestDto;
import com.arbade.gjc.model.dto.response.UserResponseDto;
import com.arbade.gjc.model.entity.User;
import com.arbade.gjc.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@Api(value = "Courier Tracking Management System", description = "Operations pertaining to courier tracking in Case Demo")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    @ApiOperation(value = "Create new  Courier Location")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(code = 201, message = "CourierLocationDto")
    public ResponseEntity<UserResponseDto> create(@RequestBody UserRequestDto userRequestDto) {

//        log.info("Create CourierLocation request is started. CourierLocationDto: {}", courierLocationDto);

        UserResponseDto userResponseDto = userService.createUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profile/{userId}")
    @ApiResponse(code = 200, message = "Total Distance")
    public ResponseEntity<?> getUserById(@ApiParam(value = "courierId of courier", required = true, example = "1") @PathVariable UUID userId) throws Exception {

        try {
            UserResponseDto userResponseDto = userService.getByUserId(userId);
            return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found", e);
        }
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/profile/delete/{userId}")
    @ApiResponse(code = 200, message = "Delete User by ID ")
    public ResponseEntity<?> deleteUserById(@ApiParam(value = "courierId of courier", required = true, example = "1") @PathVariable UUID userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/profile/deleteAll")
    @ApiResponse(code = 200, message = "Delete User by ID ")
    public ResponseEntity<?> deleteAll() {
        userService.deleteAllUser();
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/profile/users")
    @ApiResponse(code = 200, message = "Total Distance")
    public List<User> getUserList() throws Exception {
        return userService.getUsers();
    }


}
