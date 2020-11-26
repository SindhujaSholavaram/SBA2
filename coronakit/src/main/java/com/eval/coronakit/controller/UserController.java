package com.eval.coronakit.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.exception.CoronaKitException;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CoronaKitService coronaKitService;
	
	@Autowired
	KitDetailService kitDetailService;
	
	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}
	
	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		return "show-summary";
	}

	@RequestMapping("/show-list")
	public String showList(Model model) throws CoronaKitException {
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-user";
	}
	
	@RequestMapping("/add-to-cart/{id}")
	public String showKit(@PathVariable("id") int productId) throws CoronaKitException {
		CoronaKit coronaKit = coronaKitService.getKitById(productId);
		ModelAndView mv = new ModelAndView();
		mv.addObject("products", coronaKit);
		return "show-cart";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model) {
		return "checkout-address";
	}
	
	@RequestMapping("/finalize")
	public String finalizeOrder(@ModelAttribute("checkout") @Valid CoronaKit coronaKit, BindingResult result) throws CoronaKitException {
		ModelAndView mv = null;
		String view = null;
		if(result.hasErrors()) {
			mv = new ModelAndView();
			mv.addObject("checkout", coronaKit);
			view= "checkout-address";
		}
		else {
			mv = new ModelAndView();
			coronaKitService.saveKit(coronaKit);
			view = "show-summary";
		}
		return view;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable("id") int productId) throws CoronaKitException {
		ModelAndView mv = new ModelAndView();
		kitDetailService.deleteProductFromKit(productId);
		mv.addObject("msg", "Product is Deleted!!");
		return "show-cart";
	}
}
