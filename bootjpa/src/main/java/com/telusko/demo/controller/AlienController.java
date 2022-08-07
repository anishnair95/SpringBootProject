package com.telusko.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.demo.dao.AlienRepo;
import com.telusko.demo.model.Alien;

@RestController
public class AlienController {

	@Autowired
	private AlienRepo repo;
	
	@GetMapping(path="/aliens")
	public List<Alien> getAliens() {
		return repo.findAll();
	}
	
	@GetMapping("/alien/{id}")
	public Optional<Alien> getAlien(@PathVariable("id") Integer aid) {
		return repo.findById(aid);
	}
	
	@PostMapping(path="/alien",consumes="application/json")
	public Alien addAlien(@RequestBody Alien alien) {
		repo.save(alien);
		return alien;
 	}
	
	@PutMapping(path="/alien",consumes="application/json")
	public Alien saveOrUpdateAlien(@RequestBody Alien alien ) {
		repo.save(alien);
		return alien;
	}

	@DeleteMapping(path="/alien/{id}")
	public String deleteAlien(@PathVariable("id") Integer aid) {
		Alien alien = repo.getOne(aid);
		repo.delete(alien);
		return "deleted";
	}
	
	
	/*Non Rest */
	
	@RequestMapping("/home1")
	public ModelAndView home1() {

		ModelAndView mv = new ModelAndView();
		
		List<Alien> aliens = (List<Alien>) repo.findAll();
	
		mv.addObject("aliens",aliens);
		mv.setViewName("home.jsp");
		return mv;
	}
	
	@RequestMapping("/addAlien1")
	public String addAlien1(Alien alien) {
		System.out.println(alien.getAname());
		repo.save(alien);
		return "redirect:/";
	}
	
	
	@RequestMapping("/alien1/{id}")
	public String getAlien1(@PathVariable("id") Integer aid) {
				
		ModelAndView mv = new ModelAndView();
		Alien alien = repo.findById(aid).orElse(new Alien());
		
		return alien.toString();
		
	}
	
	

//	@RequestMapping("/getAlien")
//	public ModelAndView getAlien(@RequestParam Integer aid) {
//				
//		ModelAndView mv = new ModelAndView();
//		Alien alien = repo.findById(aid).orElse(new Alien());
//		
//		mv.addObject(alien);
//		System.out.println(repo.findByTech("Java"));
//		System.out.println(repo.findByAidGreaterThan(104));
//		System.out.println(repo.findByTechSorted("Android"));
//		mv.setViewName("showAlien.jsp");
//		return mv;
//		
//		
//	}
	
	
//	@RequestMapping("/getAllAliens")
//	public ModelAndView getAllAliens() {
//		
//		ModelAndView mv = new ModelAndView();
//		
//		List<Alien> aliens = (List<Alien>) repo.findAll();
//		
//		mv.addObject(aliens);
//		return mv;
//	}
}
