package com.cometsale.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cometsale.model.Address;
import com.cometsale.model.ProductDetails;
import com.cometsale.model.UserDetails;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.UserDB;
import com.cometsale.uimodel.ProductResponseModel;

@Controller
public class ProductController {

	@RequestMapping(value = "/addProduct" ,method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		System.out.println("entered add user page");
		return "newauction";
	}
	
	@RequestMapping(value = "/successfulAddedProduct", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model) {
		
		System.out.println("Added Product");
		ProductDetails newProduct = new ProductDetails();
		
		//default response
		
		ProductResponseModel userModel = new ProductResponseModel();
		userModel.setDefaultValue();

		newProduct.setProductname(request.getParameter("productName"));
		newProduct.setCategory(request.getParameter("category"));
		newProduct.setOfferPrice(Double.parseDouble(request.getParameter("offerPrice")));
		newProduct.setQuality(request.getParameter("quality"));
		newProduct.setProductDesc(request.getParameter("productDescription"));
		
		
		Address houseAddress = new Address();
		houseAddress.setCity(request.getParameter("city"));
		houseAddress.setPinCode(request.getParameter("pinCode"));
		houseAddress.setState(request.getParameter("state"));
		houseAddress.setStreetname(request.getParameter("streetName"));
		houseAddress.setAptNo(request.getParameter("AptNo"));
		newProduct.setPickupAddress(houseAddress);


		if(newProduct.getProductDesc() == null || 
				newProduct.getProductname() == null || 
		//   newUser.getUserName() == null ||
		 //  newUser.getPassword() == null ||
		   newProduct.getOfferPrice() == 0.0 || 
		   newProduct.getCategory() == null || 
		   newProduct.getPickupAddress().getCity() == null || 
		   newProduct.getPickupAddress().getPinCode() == null || 
		   newProduct.getPickupAddress().getState() == null || 
		   newProduct.getPickupAddress().getStreetname() == null){
		   model.addAttribute("ERR_MSG", "Enter all fields correctly");
		   return "registration_error";
		}
		
		// call database if successful, then return Positive response.
		// TODO: Rename GenericClassDB to some database Name.
		// TODO: GenericClassDB should give proper error if there is a problem.
		// TODO: To have specific function we need to have Db classes for each Model.
		// TODO: All Db class send some exceptions.
		
		//check if the resgistration number is already present.
		ArrayList<ProductDetails> resultList = UserDB.find(newProduct.getNetId(),"netId");
		UserDetails findResult;
		
		if(resultList!=null) {
			 findResult= UserDB.find(newProduct.getNetId(),"netId").get(0);
			 userModel.setErrorMessage("User Already Exists");
				model.addAttribute("ERR_MSG", "UserAlready Exists");
			return "registration_error";
		}
		
			
		System.out.println(newProduct);
		
		try {
			GenericClassDB.push(newProduct);
		}
		catch(Exception e) {
			userModel.setErrorMessage(e.getMessage());
			model.addAttribute("ERR_MSG", "Database Failed to register user");
		return "registration_error";
		}
		 
		return "successfulregister";
	}

}