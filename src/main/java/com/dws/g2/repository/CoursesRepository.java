package com.dws.g2.repository;

import com.dws.g2.entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<Courses, Integer> {

    @Query(value = "SELECT * FROM courses", nativeQuery = true)
    List<Courses> getAllCourses();

    @Query(value = "SELECT title from courses where id = ?", nativeQuery = true)
    String getCourseTitleById(int courseId);

}
