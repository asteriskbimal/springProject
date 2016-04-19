package com.bimal.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bimal.model.Student;
import com.bimal.serviceimpl.StudentServiceImpl;

@Controller
public class HomeController {

	@Autowired StudentServiceImpl studentServiceImpl;
	
	
	@RequestMapping(value = {"/",""})
	public String index(Model model,RedirectAttributes redirectAttributes) {

		List<Student> s =studentServiceImpl.getAllStudent();
		redirectAttributes.addFlashAttribute("student", s);
		return "redirect:/x";
	}

	@RequestMapping(value = "/o", method = RequestMethod.GET)
	public String formGet(@ModelAttribute("addStudent") Student student) {
		//model.addAttribute("addStudent", new Student());
		return "addStudent"; 
	}

	@RequestMapping(value = "/o", method = RequestMethod.POST)
	public String formPost(@ModelAttribute("addStudent") @Valid Student student,BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		// model.addAttribute("student", student);

		if (bindingResult.hasErrors()) {
		//	model.addAttribute("errors", bindingResult);
			return "addStudent";
		}
		studentServiceImpl.saveStudent(student);
		//redirectAttributes.addFlashAttribute("student", s);
		redirectAttributes.addAttribute("student", studentServiceImpl.getAllStudent());
		return "redirect:/x";
	}

	@RequestMapping(value = "/x", method = RequestMethod.GET)
	public String displayGet() {
		return "viewStudent";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(Model model,HttpServletRequest request,RedirectAttributes redirectAttributes
			, @RequestParam(value = "id", required = true) Long x){

	    studentServiceImpl.deleteStudent(x);
	    List<Student> s =studentServiceImpl.getAllStudent();
		redirectAttributes.addFlashAttribute("student", s);
		return "redirect:/x";

	}

}
