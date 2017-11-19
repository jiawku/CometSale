package com.cometsale.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cometsale.model.Address;
import com.cometsale.model.ProductDetails;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.ProductDB;
import com.cometsale.uimodel.ProductResponseModel;
import com.cometsale.mongodb.UserDB;
import com.cometsale.model.UserDetails;

@Controller
public class ProductController {

	@RequestMapping(value = "/addProduct" ,method = RequestMethod.GET)
	public String addProduct(ModelMap model) {
		System.out.println("entered add product page");
		return "newauction";
	}
	
	@RequestMapping(value = "/successfulAddedProduct", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model, @RequestParam("image") MultipartFile file)  {
		
		System.out.println("Added Product");
		ProductDetails newProduct = new ProductDetails();
		
		//default response
		
		ProductResponseModel userModel = new ProductResponseModel();
		userModel.setDefaultValue();

		newProduct.setProductName(request.getParameter("productName"));
		newProduct.setCategory(request.getParameter("category"));
		newProduct.setOfferPrice(Double.parseDouble(request.getParameter("offerPrice")));
		newProduct.setQuality(request.getParameter("quality"));
		newProduct.setProductDesc(request.getParameter("productDescription"));
		if(!file.isEmpty()) {
			
			byte[] bytes;
			try {
				bytes = file.getBytes();
				newProduct.setImageBytes(bytes);
				System.out.println("size"+Integer.toString(bytes.length)+"uploaded size:"+Integer.toString(newProduct.getImageBytes().length));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  
			
		}
		
		Address houseAddress = new Address();
		houseAddress.setCity(request.getParameter("city"));
		houseAddress.setPinCode(request.getParameter("pinCode"));
		houseAddress.setState(request.getParameter("state"));
		houseAddress.setStreetname(request.getParameter("streetName"));
		houseAddress.setAptNo(request.getParameter("AptNo"));
		newProduct.setPickupAddress(houseAddress);

		System.out.println(newProduct.getProductID());
		System.out.println(newProduct.getProductDesc());
		System.out.println(newProduct.getPickupAddress().getCity());
		   

		if(newProduct.getProductDesc() == null || 
				newProduct.getProductName() == null || 
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
		ArrayList<ProductDetails> resultList = ProductDB.find(newProduct.getProductID(),"productID");
		
		if(!(resultList.isEmpty())) {
			 userModel.setErrorMessage("Product Already Exists");
				model.addAttribute("ERR_MSG", "Product Already Exists");
			return "registration_error";
		}
		
		System.out.println(newProduct);
		
		try {
			GenericClassDB.push(newProduct);
		}
		catch(Exception e) {
			userModel.setErrorMessage(e.getMessage());
			model.addAttribute("ERR_MSG", "Database Failed to register product");
		return "registration_error";
		}
		 
		return "successfulproductadded";
	}

}