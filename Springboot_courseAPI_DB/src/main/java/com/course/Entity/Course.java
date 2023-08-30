package com.course.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Course 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //preferred n good for mysql DB for rest use AUTO
	private Long Id;
	private String title;
	private String description;
		
	public Course(Long id, String title, String description) {
		super();
		Id = id;
		this.title = title;
		this.description = description;
	}
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Course [Id=" + Id + ", title=" + title + ", description=" + description + "]";
	}
	
	
}
