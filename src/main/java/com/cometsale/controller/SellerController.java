package com.cometsale.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cometsale.model.Product;
import com.cometsale.model.Student;
import com.cometsale.mongodb.UserDB;

@Controller
public class SellerController {

	@RequestMapping(value = "/viewOffers/{productId}" ,method = RequestMethod.GET)
	public String addToWishlist(HttpSession session,HttpServletRequest request, ModelMap model, @PathVariable String productId) {
		System.out.println("entered");
		Product dumyProduct= new Product();
		dumyProduct.setProductId(productId);
		
		String netID = session.getAttribute("NetID").toString();
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
		System.out.println("NetID: "+netID);
		Student s = findResult.get(0);
		
		s.addProductToWishlist(dumyProduct);
		
		return "viewOffers";
	}
	
}
