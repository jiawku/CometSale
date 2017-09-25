package com.cometsale.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cometsale.authenticate.SessionManagement;
import com.cometsale.beans.LoginBean;
import com.cometsale.model.Address;
import com.cometsale.model.UserDetails;
import com.cometsale.mongodb.GenericClassDB;
import com.cometsale.mongodb.UserDB;
import com.cometsale.uimodel.UserResponseModel;

@Controller
public class UserController {
	
	@RequestMapping(value = {"/viewProfile"}, method = RequestMethod.GET)
	 	public String viewProfile(HttpServletRequest request,ModelMap model){
	 		return "userinfo";
	 	}
	
	@RequestMapping(value = "/addUser" ,method = RequestMethod.GET)
	public String addNewUser(ModelMap model) {
		System.out.println("entered add user page");
		return "registration";
	}
	
	@RequestMapping(value = {"/"}, method = RequestMethod.GET)
	public String welcome(ModelMap model) {
		System.out.println("entered normal");
		return "registration";
	}
	
	@RequestMapping(value = "/successfulLogin", method = RequestMethod.GET)
	public String successfulLogin(HttpServletRequest request,ModelMap model) {
		LoginBean bean = new LoginBean();
		bean.setuserName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		//TODO: password Authenication.
		request.setAttribute("bean", bean);
		SessionManagement.createSessionUser(request, bean,0);	
		return "userdetails";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request,ModelMap model) {
		LoginBean bean = new LoginBean();
		bean.setuserName(request.getParameter("name"));
		bean.setPassword(request.getParameter("password"));
		//TODO: password Authenication.
		request.setAttribute("bean", bean);
		SessionManagement.createSessionUser(request, bean,0);	
		return "loginpage";
		
	}
	
	@RequestMapping(value ="/homepage", method = RequestMethod.GET)
	 	public String directToHomepage(HttpServletRequest request,ModelMap model){
	 		return "homepage";
	  	}
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request,ModelMap model) {
		
		System.out.println("entered Register");
		UserDetails newUser = new UserDetails();
		
		//default response
		
		UserResponseModel userModel = new UserResponseModel();
		userModel.setDefaultValue();

		newUser.setNetId(request.getParameter("netId"));
		//newUser.setUserName(request.getParameter("username"));
		newUser.setFirstName(request.getParameter("firstName"));
		newUser.setLastName(request.getParameter("lastName"));
		//TODO:password.
		newUser.setEmail(request.getParameter("email"));
		newUser.setPhoneNumber(request.getParameter("phoneNumber"));
		
		Address houseAddress = new Address();
		houseAddress.setCity(request.getParameter("city"));
		houseAddress.setPinCode(request.getParameter("pinCode"));
		houseAddress.setState(request.getParameter("state"));
		houseAddress.setStreetname(request.getParameter("streetName"));
		houseAddress.setAptNo(request.getParameter("AptNo"));
		newUser.setHomeAddress(houseAddress);


		if(newUser.getNetId() == null || 
		   newUser.getLastName() == null || 
		//   newUser.getUserName() == null ||
		 //  newUser.getPassword() == null ||
		   newUser.getEmail() == null || 
		   newUser.getPhoneNumber() == null || 
		   newUser.getHomeAddress().getCity() == null || 
		   newUser.getHomeAddress().getPinCode() == null || 
		   newUser.getHomeAddress().getState() == null || 
		   newUser.getHomeAddress().getStreetname() == null){
		   model.addAttribute("ERR_MSG", "Enter all fields correctly");
		   return "registration_error";
		}
		
		// call database if successful, then return Positive response.
		// TODO: Rename GenericClassDB to some database Name.
		// TODO: GenericClassDB should give proper error if there is a problem.
		// TODO: To have specific function we need to have Db classes for each Model.
		// TODO: All Db class send some exceptions.
		
		//check if the resgistration number is already present.
		ArrayList<UserDetails> resultList = UserDB.find(newUser.getNetId(),"netId");
		UserDetails findResult;
		
		if(resultList!=null) {
			 findResult= UserDB.find(newUser.getNetId(),"netId").get(0);
			 userModel.setErrorMessage("User Already Exists");
				model.addAttribute("ERR_MSG", "UserAlready Exists");
			return "registration_error";
		}
		
			
		System.out.println(newUser);
		
		try {
			GenericClassDB.push(newUser);
		}
		catch(Exception e) {
			userModel.setErrorMessage(e.getMessage());
			model.addAttribute("ERR_MSG", "Database Failed to register user");
		return "registration_error";
		}
		 
		return "successfulregister";
	}

}
