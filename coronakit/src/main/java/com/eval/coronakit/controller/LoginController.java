package com.eval.coronakit.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.Roles;
import com.eval.coronakit.entity.User;
import com.eval.coronakit.exception.CoronaKitException;
import com.eval.coronakit.service.KitDetailServiceImpl;

@Controller
public class LoginController {

	
	@Autowired
	KitDetailServiceImpl kitDetailServiceImpl;
	
	@RequestMapping("/custom-login")
	public String login() {
		return "login-form";
	}
	
	@RequestMapping("/custom-error")
	public String error() {
		return "error-page";
	}

	@GetMapping({ "", "/", "/home" })
	public String goHome() {
		return "index";		
	}
	
	@RequestMapping("/validate")
	public ModelAndView showHeader() {

		ModelAndView mv = new ModelAndView("main-menu");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			String role = new ArrayList<>(auth.getAuthorities()).get(0).getAuthority();
			
			mv.addObject("username", auth.getName());
			mv.addObject("role", role);
		}
		return mv;
		
	}
	
	@GetMapping("/validate")
	public String gotoLogin() {
		String view="loginPage";
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated()) {
			view="redirect:/home";
		}

		return view; 
	}
	
	@PostMapping("/register-save")
	public String doAddUser(@ModelAttribute("userDetails") @Valid User user, @ModelAttribute("userDetails") @Valid Roles roles, BindingResult result ) throws CoronaKitException {
		ModelAndView mv = null;
		String view = null;
		if(result.hasErrors()) {
			mv = new ModelAndView();
			mv.addObject("userDetails",user);
			mv.addObject("userDetails",roles);
			view = "add-new-item";
		}else {
			mv = new ModelAndView();
			kitDetailServiceImpl.addUserDetails(user,roles);
			mv.addObject("msg","User is Saved!!");
			view = "admin-home";
		}
		return view; 
	}
}
