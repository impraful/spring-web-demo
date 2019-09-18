package com.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.model.Student;

@Controller
@RequestMapping("/student")
public class StudentController {

	public StudentController() {
		System.out.println("student controller ..");
	}

	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String name1() {
		System.out.println("student details ...");
		return "studentRegisterForm";
	}

	// Access query parameter using HttpServletRequest
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String name2(HttpServletRequest request) {
		System.out.println("register .....");
		String name = request.getParameter("name");
		String branch = request.getParameter("branch");
		String address = request.getParameter("address");
		System.out.println("name : " + name + "\nbranch : " + branch + "\nadress : " + address);
		return "studentRegisterForm";
	}

	// Access query parameter using Model Object
	@RequestMapping(value = "/register1", method = RequestMethod.POST)
	public String name4(Student student) {
		System.out.println("register1 .....");
		System.out.println("student details " + student);
		return "studentRegisterForm";
	}

	// Access query parameter using @RequestParam annotation
	@RequestMapping(value = "/register2", method = RequestMethod.POST)
	public String name5(@RequestParam String name, @RequestParam("address") String addr, String branch) {
		System.out.println("register2 .....");
		System.out.println("name : " + name + "\nbranch : " + branch + "\nadress : " + addr);
		return "studentRegisterForm";
	}

	// Access query parameter using @RequestParam annotation
	@RequestMapping(value = "/register3/{name}/{address}", method = RequestMethod.GET)
	public String name6(@PathVariable("address") String addr, @PathVariable String name) {
		System.out.println("register3 .....");
		System.out.println("name : " + name + "\nadress  : " + addr);
		return "studentRegisterForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public String name3() {
		System.out.println("student name1 ...");
		return "studentRegisterForm";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	public String name4() {
		System.out.println("student name1 ...");
		return "studentRegisterForm";
	}
}
