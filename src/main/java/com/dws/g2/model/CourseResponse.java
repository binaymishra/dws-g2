package com.dws.g2.model;

import lombok.Data;

@Data
public class CourseResponse {
    private String courseName;
    private String authorName;
    private int enrolledUsers;
}
