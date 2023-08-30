package com.course.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.course.Entity.Course;
import com.course.Service.CourseService;

@RestController
public class MyController {

	@Autowired  
	private CourseService courseServ;
	
	// Checking application running or not running
	@GetMapping("/")	//http://localhost:8083/home
	public String home() {
		return "Welcome to courses application";
	}
	
	// Endpoint to GET all the data from DB
	@GetMapping("/courses")   //http://localhost:8083/courses
	public List<Course> getCourses()
	{
		return this.courseServ.getCourses();  // bina this k bhi kaam chal jayega
	}
	
	// Endpoint to GET the data of particular ID from DB
	@GetMapping("/courses/{courseId}")
	public Optional<Course> getCourse(@PathVariable String courseId)
	{
		return this.courseServ.getCourse(Long.parseLong(courseId));
	}
	
	// Endpoint to SAVE the data into DB
//	@PostMapping(path="/courses", consumes = "application/json")  consumes nahi likha tobhi chal jata hai
	@PostMapping("/courses")  //http://localhost:8083/courses
	public Course addCourse(@RequestBody Course courseAdd)
	{
		return this.courseServ.addCourse(courseAdd);
	}
	
	// Endpoint to UPDATE the data into DB
	@PutMapping("/courses")  //http://localhost:8083/courses
	public Course updateCourse(@RequestBody Course editCourse)
	{
		return this.courseServ.updateCourse(editCourse);
	}
	
	// Endpoint to DELETE the data from DB
	@DeleteMapping("/courses/{courseDelId}")  //http://localhost:8083/courses/3
	public String deleteCourse(@PathVariable String courseDelId)
	{
		return this.courseServ.deleteCourse(Long.parseLong(courseDelId));
		//Using the this keyword is not strictly necessary in this context, but it can help improve code 
		//readability and clarity. The this keyword is used to refer to the current instance of the class, 
		//and using it can help differentiate between instance variables/methods and local variables.
	}
}









