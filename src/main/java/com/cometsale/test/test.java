/*
 * Copyright 2017 MongoDB, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.cometsale.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.cometsale.model.Address;
import com.cometsale.model.UserDetails;
import com.cometsale.mongodb.UserDB;
import com.cometsale.uimodel.UserResponseModel;

import com.cometsale.model.ProductDetails;
import com.cometsale.mongodb.OldProductDB;


public class test {
  
    public static void main(final String[] args) {
       
/*	UserDetails newUser = new UserDetails();
		
		newUser.setNetID("20237865");
		//newUser.setUserName(request.getParameter("username"));
		newUser.setFirstName("Akhilesh");
		newUser.setLastName("Kumar");
		//TODO:password.
		newUser.setEmail("akhi.x319@gmail.com");
		newUser.setPhoneNumber("4696644745");
		
		Address houseAddress = new Address();
		houseAddress.setCity("Dallas");
		houseAddress.setPinCode("75252");
		houseAddress.setState("Richardson");
		houseAddress.setStreetname("7815 McCallum");
		houseAddress.setAptNo("16101");
		newUser.setHomeAddress(houseAddress);
		
		UserDB.push(newUser);
		
		
		UserDetails newUser2 = new UserDetails();
		
		
		newUser2.setNetID("202378651");
		//newUser.setUserName(request.getParameter("username"));
		newUser2.setFirstName("Akhilesh1");
		newUser2.setLastName("Kumar");
		//TODO:password.
		newUser2.setEmail("akhi.x319@gmail.com");
		newUser2.setPhoneNumber("4696644745");
		
		Address houseAddress2 = new Address();
		houseAddress2.setCity("Dallas");
		houseAddress2.setPinCode("75252");
		houseAddress2.setState("Richardson");
		houseAddress2.setStreetname("7815 McCallum");
		houseAddress2.setAptNo("16101");
		newUser2.setHomeAddress(houseAddress2);
		System.out.println(newUser2);
		
		UserDB.push(newUser2);
		
   
	  UserDetails findResult= UserDB.find("Akhilesh1","firstName").get(0);
	  System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetID());
	    
	  UserDB.update("202378651","netID","updateFirstName", "firstName");
	  
	  findResult=(UserDetails) UserDB.find("202378651","netID").get(0);
	  System.out.println("firstName:"+findResult.getFirstName()+"\nNetID:"+findResult.getNetID());*/
      
      ProductDetails testProduct=new ProductDetails();
      
      
      File path = new File("C:\\Users\\Jiawku\\Desktop\\test.jpg");
      testProduct.setProductid(8888);
      
      FileInputStream imageInFile;
	try {
	imageInFile = new FileInputStream(path);
      byte[] imageData = new byte[(int) path.length()];
		imageInFile.read(imageData);
	
      testProduct.setImageBytes(imageData);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
//      System.out.println("Product:"+testProduct.encodeImageBytes);	
     OldProductDB.push(testProduct);
      
    }
}