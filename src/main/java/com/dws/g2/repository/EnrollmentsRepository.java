package com.dws.g2.repository;

import com.dws.g2.entity.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnrollmentsRepository extends JpaRepository<Enrollments, Integer> {

    @Query(value = "SELECT * FROM enrollments WHERE user_id = ?", nativeQuery = true)
    List<Enrollments> getEnrollmentsByUserId(int userId);

    @Query(value = "SELECT count(*) from enrollments where course_id = ?", nativeQuery = true)
    int countEnrollmentsByCourseId(int courseId);
}
