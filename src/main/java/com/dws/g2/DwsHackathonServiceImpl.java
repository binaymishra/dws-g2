package com.dws.g2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Binay Mishra
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DwsHackathonServiceImpl implements DwsHackathonService {

  private final DwsHackathonRepository repository;

}
