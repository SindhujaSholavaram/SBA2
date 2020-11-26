package com.eval.coronakit.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaKitException;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;
	
	@GetMapping("/home")
	public String home() {
		return "main-menu";
	}
	
	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", new ProductMaster());
		mv.addObject("isNew", true);
		return "show-all-item-admin";
	}
	
	@PostMapping("/product-save")
	public String productSave(@ModelAttribute ProductMaster product, BindingResult result) throws CoronaKitException {
		ModelAndView mv = null;
		String view = null;
		if (result.hasErrors()) {
			mv = new ModelAndView();
			mv.addObject("product", product);
			mv.addObject("isNew", false);
			view = "add-new-item";
		} else {
			mv = new ModelAndView();
			productService.addNewProduct(product);
			mv.addObject("msg", "Item is saved!");
			view = "admin-home";
		}
		return view;
	}

	@PostMapping("/addItem")
	public String doAddItem(@ModelAttribute("product") @Valid ProductMaster product, BindingResult result) throws CoronaKitException {
		ModelAndView mv = null;
		String view = null;
		if (result.hasErrors()) {
			mv = new ModelAndView();
			mv.addObject("product", product);
			mv.addObject("isNew", true);
			view = "add-new-item";
		} else {
			mv = new ModelAndView();
			productService.addNewProduct(product);
			mv.addObject("msg", "Item is saved!");
			view = "admin-home";
		}
		return view;
	}
	
	@GetMapping("/product-edit")
	public String showItemFormForEditing(@RequestParam("id") int id) throws CoronaKitException {
		ProductMaster product = productService.getProductById(id);
		ModelAndView mv = new ModelAndView();
		mv.addObject("product", product);
		mv.addObject("isNew", false);
		return "add-new-item";
	}
	
	@GetMapping("/product-list")
	public String productList(Model model) throws CoronaKitException {
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-admin";
	}
	
	@GetMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId) throws CoronaKitException {
		ModelAndView mv = new ModelAndView();
		productService.deleteProduct(productId);
		mv.addObject("msg","Item is deleted!");
		return "show-all-item-admin";
	}
	
}
