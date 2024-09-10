package com.dws.g2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Binay Mishra
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class DwsHackathonEndpoints {

  private final DwsHackathonService service;

  @GetMapping(value = {"/", "/welcome"})
  public ResponseEntity<Object> welcome(@RequestParam(value = "name", defaultValue = "") String name) {
    return ResponseEntity.ok(name);
  }

}
