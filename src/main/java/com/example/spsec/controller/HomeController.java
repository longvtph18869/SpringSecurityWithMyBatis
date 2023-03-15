package com.example.spsec.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.spsec.dao.AccountDao;
import com.example.spsec.dao.RoleDao;
import com.example.spsec.entities.Account;
import com.example.spsec.entities.Role;
import com.example.spsec.util.EncrytedPasswordUtils;

@RestController
public class HomeController {
	@Autowired
	AccountDao accountDao;
	
	@Autowired
	RoleDao roleDao;

	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("login");
		return modelAndView;
	}
	@GetMapping("/admin")
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView("admin");
		return modelAndView;
	}

	@GetMapping("")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("home");
		return modelAndView;
	}

	@RequestMapping("/default")
	public ModelAndView defaultAfterLogin(HttpServletRequest request) {
		ModelAndView modelAndView;
		if (request.isUserInRole("ROLE_ADMIN")) {
			modelAndView = new ModelAndView("redirect:/admin");
		} else {
			modelAndView = new ModelAndView("redirect:/");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accessDenied(Principal principal) {
		ModelAndView modelAndView = new ModelAndView("403");
		if (principal != null) {
			String message = "Hi " + principal.getName() //
					+ "<br>Ban khong the vao trang nay!";
			modelAndView.addObject("message", message);
		}
		return modelAndView;
	}

	@GetMapping("/save")
	public ModelAndView save() {
		accountDao.insert(new Account(1L, "admin", EncrytedPasswordUtils.encrytePassword("123")));
		accountDao.insert(new Account(2L, "user", EncrytedPasswordUtils.encrytePassword("123")));
		roleDao.insert(new Role(1L, 1L, "ROLE_ADMIN"));
		roleDao.insert(new Role(2L, 2L, "ROLE_USER"));
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
}
