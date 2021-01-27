package com.arbade.gjc.controller;


import com.arbade.gjc.model.dto.request.ScoreRequestDto;
import com.arbade.gjc.model.dto.response.ScoreResponseDto;
import com.arbade.gjc.service.ScoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/score")
@Api(value = "Courier Tracking Management System", description = "Operations pertaining to courier tracking in Case Demo")
@RequiredArgsConstructor
@Slf4j
public class ScoreController {

    private ScoreService scoreService;

    @Autowired
    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @PostMapping
    @ApiOperation(value = "Create new  Courier Location")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(code = 201, message = "CourierLocationDto")
    public ResponseEntity<ScoreResponseDto> submit(@RequestBody ScoreRequestDto scoreRequestDto) throws Exception {
        ScoreResponseDto scoreResponseDto = scoreService.submit(scoreRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(scoreResponseDto);
    }


}
