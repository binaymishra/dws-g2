package com.dws.g2.controller;

import com.dws.g2.model.CourseResponse;
import com.dws.g2.model.FundDetailsResponse;
import com.dws.g2.model.LeaderBoardResponse;
import com.dws.g2.model.StreakResponse;
import com.dws.g2.model.UserFundDetailsBody;
import com.dws.g2.service.DwsHackathonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Binay Mishra
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@CrossOrigin
public class DwsHackathonEndpoints {

  private final DwsHackathonService service;

  @GetMapping(value = {"/", "/welcome"})
  public ResponseEntity<Object> welcome(@RequestParam(value = "name", defaultValue = "") String name) {
    return ResponseEntity.ok(name);
  }

  @GetMapping(value = {"/leaderboard"})
  public ResponseEntity<List<LeaderBoardResponse>> getLeaderBoard() {
    return ResponseEntity.ok(service.getLeaderBoard());

  }

  @GetMapping(value = {"/courses"})
  public ResponseEntity<List<CourseResponse>> getCourses(@RequestParam(value = "userName", defaultValue = "", required = false) String userName) {
      return ResponseEntity.ok(service.getCourseDetails(userName));
  }

  @GetMapping(value = {"/streaks"})
  public ResponseEntity<StreakResponse> getStreaks(@RequestParam(value = "userName", defaultValue = "") String userName) {
    return ResponseEntity.ok(service.getStreaks(userName));
  }

  @GetMapping(value = {"/fundDetails"})
  public ResponseEntity<List<FundDetailsResponse>> getFundDetails(@RequestParam(value = "userName", defaultValue = "") String userName) {
      return ResponseEntity.ok(service.getFundDetails(userName));
  }

  @PostMapping(value = {"/investInFund"})
  public ResponseEntity<Object> investInFund(@RequestBody UserFundDetailsBody userFundDetailsBody) {
    log.info("Investing in fund: {}", userFundDetailsBody.getUserFundDetails());
    return ResponseEntity.ok(service.investInFund(userFundDetailsBody));
  }

  @PostMapping(value = {"/completeCourse"})
  public ResponseEntity<Object> completeCourse(@RequestParam(value = "userName", defaultValue = "") String userName, @RequestParam(value = "courseId", defaultValue = "0") int courseId) {
        log.info("Completing course: {}", courseId);
        return ResponseEntity.ok(service.completeCourse(userName, courseId));
  }

  @PostMapping(value = {"/enrollUserIntoCourse"})
  public ResponseEntity<Object> enrollUserIntoCourse(@RequestParam(value = "userName", defaultValue = "") String userName, @RequestParam(value = "courseId", defaultValue = "0") int courseId) {
        log.info("Enrolling user into course: {}", courseId);
        return ResponseEntity.ok(service.enrollUserIntoCourse(userName, courseId));
    }

}
