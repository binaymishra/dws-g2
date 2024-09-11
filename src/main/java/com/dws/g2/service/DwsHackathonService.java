package com.dws.g2.service;

import com.dws.g2.model.CourseResponse;
import com.dws.g2.model.FundDetailsResponse;
import com.dws.g2.model.LeaderBoardResponse;
import com.dws.g2.model.MessageResponse;
import com.dws.g2.model.StreakResponse;
import com.dws.g2.model.UserFundDetail;
import com.dws.g2.model.UserFundDetailsBody;

import java.util.List;

/**
 * @author Binay Mishra
 */
public interface DwsHackathonService {

    String getUserName(int id);

    List<LeaderBoardResponse> getLeaderBoard();

    List<CourseResponse> getCourseDetails(String userName);

    StreakResponse getStreaks(String userName);

    List<FundDetailsResponse> getFundDetails();
    MessageResponse investInFund(UserFundDetailsBody userFundDetailsBody);

}
