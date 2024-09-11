package com.dws.g2.service;

import com.dws.g2.entity.Courses;
import com.dws.g2.entity.Enrollments;
import com.dws.g2.entity.FundDetails;
import com.dws.g2.entity.Rewards;
import com.dws.g2.entity.Streaks;
import com.dws.g2.entity.UserFundDetails;
import com.dws.g2.entity.Users;
import com.dws.g2.model.CourseResponse;
import com.dws.g2.model.FundDetailsResponse;
import com.dws.g2.model.LeaderBoardResponse;
import com.dws.g2.model.MessageResponse;
import com.dws.g2.model.StreakResponse;
import com.dws.g2.model.UserFundDetail;
import com.dws.g2.model.UserFundDetailsBody;
import com.dws.g2.repository.CoursesRepository;
import com.dws.g2.repository.DwsHackathonRepository;
import com.dws.g2.repository.EnrollmentsRepository;
import com.dws.g2.repository.FundDetailsRepository;
import com.dws.g2.repository.RewardsRepository;
import com.dws.g2.repository.StreakRepository;
import com.dws.g2.repository.UserFundDetailsRepository;
import com.dws.g2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Binay Mishra
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DwsHackathonServiceImpl implements DwsHackathonService {

  private final DwsHackathonRepository repository;

  private final UserRepository userRepository;
  private final RewardsRepository rewardsRepository;

  private final CoursesRepository coursesRepository;
  private final EnrollmentsRepository enrollmentsRepository;
  private final StreakRepository streakRepository;
  private final FundDetailsRepository fundDetailsRepository;
  private final UserFundDetailsRepository userFundDetailsRepository;

  public String getUserName(int id) {
      Users user = userRepository.findById(id);
      return user.getUsername();
  }

  public List<LeaderBoardResponse> getLeaderBoard() {

    List<Rewards> rewards = rewardsRepository.getTopRewards();
    List<LeaderBoardResponse> leaderBoardResponses = new ArrayList<>();
    for (Rewards reward : rewards) {
        LeaderBoardResponse leaderBoardResponse = new LeaderBoardResponse();
        log.info("Rewards: {}", reward);
        leaderBoardResponse.setScore(reward.getReward());
        leaderBoardResponse.setUserName(getUserName(reward.getUserId()));
        leaderBoardResponses.add(leaderBoardResponse);
    }
    return leaderBoardResponses;
  }

  public List<CourseResponse> getCourseDetails(String username) {
      List<CourseResponse> courseResponses = new ArrayList<>();
      if (username == null || username.isEmpty()) {
          List<Courses> courses =  coursesRepository.getAllCourses();
          for (Courses course : courses) {
              CourseResponse courseResponse = new CourseResponse();
              courseResponse.setCourseName(course.getTitle());
              courseResponse.setEnrolledUsers(enrollmentsRepository.countEnrollmentsByCourseId(course.getId()));
              courseResponses.add(courseResponse);
          }
          return courseResponses;
      } else {
          int userId = userRepository.findByUsername(username).getId();
          List<Enrollments> enrollmentsList = enrollmentsRepository.getEnrollmentsByUserId(userId);
          for (Enrollments enrollment : enrollmentsList) {
              CourseResponse courseResponse = new CourseResponse();
              courseResponse.setCourseName(coursesRepository.getCourseTitleById(enrollment.getCourseId()).getTitle());
              courseResponse.setEnrolledUsers(enrollmentsRepository.countEnrollmentsByCourseId(enrollment.getCourseId()));
              courseResponses.add(courseResponse);
          }
          return courseResponses;
      }
  }

  private int getRank(int userId) {
      List<Rewards> rewards = rewardsRepository.getAllRewards();
      int rank = 0;
      for (Rewards reward : rewards) {
          rank++;
          if (reward.getUserId() == userId) {
              return rank;
          }
      }
      return rank;
  }

  private List<Boolean> getStreaks(int userId) {
      List<Streaks> streaks = streakRepository.getStreaksByUserId(userId);

      Map<LocalDate, Boolean> dateMap = new HashMap<>();

      // Get today's date
      LocalDate today = LocalDate.now();

      // Loop through the last 7 days, including today
      for (int i = 0; i < 7; i++) {
          LocalDate date = today.minusDays(i);
          dateMap.put(date, false);  // You can assign true or false based on your logic
      }

      for (Streaks streak : streaks) {
          dateMap.put(streak.getLoginDate(), true);
      }

      return new ArrayList<>(dateMap.values());
  }

  public StreakResponse getStreaks(String userName) {
      StreakResponse streakResponses = new StreakResponse();
      int userId = userRepository.findByUsername(userName).getId();
      streakResponses.setRank(getRank(userId));
      streakResponses.setScore(rewardsRepository.getRewardsByUserId(userId).getReward());
      streakResponses.setStreak(getStreaks(userId));
      return streakResponses;
  }

  public List<FundDetailsResponse> getFundDetails(String userName) {
      List<FundDetailsResponse> fundDetailsResponses = new ArrayList<>();
      List<FundDetails> fundDetails = fundDetailsRepository.getAllFundDetails();
      for (FundDetails fundDetail : fundDetails) {
          FundDetailsResponse fundDetailsResponse = new FundDetailsResponse();
          fundDetailsResponse.setFundName(fundDetail.getFundName());
          fundDetailsResponse.setMornigstarRating(fundDetail.getMornigstarRating());
          fundDetailsResponse.setSharpeRatio(fundDetail.getSharpeRatio().doubleValue());
          fundDetailsResponse.setTrackingError(fundDetail.getTrackingError().doubleValue());
          fundDetailsResponse.setInformationRatio(fundDetail.getInformationRatio().doubleValue());
          fundDetailsResponse.setEsgScore(fundDetail.getEsgScore());
          fundDetailsResponse.setSector(fundDetail.getSector());
          fundDetailsResponses.add(fundDetailsResponse);

          int userId = userRepository.findByUsername(userName).getId();
          UserFundDetails userFundDetails = userFundDetailsRepository.getUserFundDetailsByUserIdAndFundId(userId, fundDetail.getId());
          if (userFundDetails != null) {
              fundDetailsResponse.setContribution(userFundDetails.getContribution());
              fundDetailsResponse.setContributionFrequency(userFundDetails.getContributionFrequency());
              fundDetailsResponse.setBoostFactor(userFundDetails.getBoostFactor());
              fundDetailsResponse.setContributionCap(userFundDetails.getContributionCap());
          }
      }
      return fundDetailsResponses;
  }

  public MessageResponse investInFund(UserFundDetailsBody userFundDetailsBody) {
      UserFundDetails userFundDetails = new UserFundDetails();
      log.info("UserFundDetails: {}", userFundDetailsBody.getUserFundDetails());
      for (UserFundDetail userFundDetail : userFundDetailsBody.getUserFundDetails()) {
          userFundDetails.setUserId(userFundDetail.getUserId());
          userFundDetails.setFundId(userFundDetail.getFundId());
          userFundDetails.setContribution(userFundDetail.getContribution());
          userFundDetails.setContributionFrequency(userFundDetail.getContributionFrequency());
          userFundDetails.setBoostFactor(userFundDetail.getBoostFactor());
          userFundDetails.setContributionCap(userFundDetail.getContributionCap());
          userFundDetailsRepository.save(userFundDetails);
      }
      MessageResponse messageResponse = new MessageResponse();
      messageResponse.setMessage("Investment successful");
      return messageResponse;

  }

  public MessageResponse enrollUserIntoCourse(String username, int courseId) {
      int userId = userRepository.findByUsername(username).getId();
      Enrollments enrollment = new Enrollments();
      enrollment.setUserId(userId);
      enrollment.setCourseId(courseId);
      enrollment.setCompleted(false);
      enrollmentsRepository.save(enrollment);
      MessageResponse messageResponse = new MessageResponse();
      messageResponse.setMessage("Enrollment successful");
      return messageResponse;
  }

  public MessageResponse completeCourse(String username, int courseId) {
      int userId = userRepository.findByUsername(username).getId();
      Enrollments enrollment = new Enrollments();
      enrollment.setUserId(userId);
      enrollment.setCourseId(courseId);
      enrollment.setCompleted(true);
      enrollmentsRepository.save(enrollment);

      Courses course = coursesRepository.getCourseTitleById(courseId);
      int score = course.getScore();
      Rewards reward = rewardsRepository.getRewardsByUserId(userId);
      reward.setReward(reward.getReward() + score);
      rewardsRepository.save(reward);
      MessageResponse messageResponse = new MessageResponse();
      messageResponse.setMessage("Course completed successfully");
      return messageResponse;
  }
}
