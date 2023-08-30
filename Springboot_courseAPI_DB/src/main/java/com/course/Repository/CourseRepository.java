package com.course.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.course.Entity.Course;


public interface CourseRepository extends JpaRepository<Course, Long> {
	public List<Course> findByTitle(String title);
	public List<Course> findByDescription(String description);
}
