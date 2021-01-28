package com.arbade.gjc.controller;


import com.arbade.gjc.model.entity.Leaderboard;
import com.arbade.gjc.model.entity.User;
import com.arbade.gjc.service.LeaderboardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/leaderboard")
@Api(value = "Courier Tracking Management System", description = "Operations pertaining to courier tracking in Case Demo")
@RequiredArgsConstructor
@Slf4j
public class LeaderboardController {

    private final LeaderboardService leaderboardService;

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    @ApiResponse(code = 200, message = "Total Distance")
    public List<Leaderboard> getLeaderboardList() throws Exception {
        return leaderboardService.getLeaderboard();
    }

    @ApiOperation(value = "Get total distance of courier")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{country}")
    @ApiResponse(code = 200, message = "Total Distance")
    public List<Leaderboard> getLeaderboardList(@ApiParam(value = "courierId of courier", required = true, example = "1")  @PathVariable String country) throws Exception {
        return leaderboardService.getLeaderboardByCountry(country);
    }


}
