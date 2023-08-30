package com.course.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.course.Entity.Course;
import com.course.Repository.CourseRepository;

@Service
public class CourseService  {

	@Autowired
	private CourseRepository courseRepo;

	
	public List<Course> getCourses() {
		return courseRepo.findAll();
	}
    //"Optional" ek Java class hai jo khaas tarike se null pointer exceptions se bachane aur safer code 
	//likhne mein madad karta hai. Jab hum kisi value ko "Optional" mein rakhte hain, to yeh batata hai ki 
	// yeh value ho sakti hai ya fir woh null bhi ho sakti hai.
	
	public Optional<Course> getCourse(long courseId) {
		return courseRepo.findById(courseId);
	}

	
	public Course addCourse(Course courseAdd) {
		return courseRepo.save(courseAdd);
	}

	
	public Course updateCourse(Course editCourse) {
		return courseRepo.save(editCourse);
	}

	public String deleteCourse(long courseDelId) {
		Optional<Course> course = courseRepo.findById(courseDelId);
		// isPresent(): Yeh method check karta hai ki value present hai ya nahi. Agar present hai to 
		// true return karta hai, warna false.
		if (course.isPresent()) 
		{
			courseRepo.delete(course.get());
			// The get() method is used to retrieve the value from an Optional object. In the context 
			// of your code, you're using it to retrieve the Course object from the Optional<Course> 
			// returned by the findById method.
			String msg = "\nData deleted Successfully";
			return msg;
		}
		return "Unable to delete data";
	}

}
