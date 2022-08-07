package com.springrest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.model.Course;
import com.springrest.services.CourseService;

@RestController
@CrossOrigin
public class MyController {
	
	@Autowired
   private CourseService courseService;
	
	@GetMapping("/")
   public String home() {
	   
	  return "THis is home page";
   }
   
   
   @GetMapping("/courses")
   public List<Course> getCourses(){
	   
	   return courseService.getCourses();
   }
   
   @GetMapping("/courses/{courseId}")
   public Optional<Course> getCourse(@PathVariable("courseId") long courseId){
	   
	   return courseService.getCourse(courseId);
   }
   
   @PostMapping(path="/courses",consumes="application/json")
   public Course addCourse(@RequestBody Course course) {
	 return courseService.addCourse(course);
   }
   
   @PutMapping("/courses")
   public Course updateCourse(@RequestBody Course course){
	   
	   return courseService.updateCourse(course);
   }
   
   @DeleteMapping("/courses/{courseId}")
   public ResponseEntity<String> deleteCourse(@PathVariable("courseId") long courseId){
	   
	   try {
		   courseService.deleteCourse(courseId);
		   return new ResponseEntity<>("Course deleted successfully",HttpStatus.OK);
	   }
	   catch(Exception e){
		   return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	   }
	   
	  
   }
}