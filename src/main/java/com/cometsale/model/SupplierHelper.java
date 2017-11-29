package com.cometsale.model;

import java.util.ArrayList;

public class SupplierHelper {
	
	
	public void postProduct(){
		
	}

	public ArrayList<Student> fetchOfferedBuyer(Student seller,Product p){
		
		if(p.getSeller().getNetid()==seller.getNetid()) {
			ArrayList<Student> output= new ArrayList<Student>();
			ArrayList<Offer> offers=p.getOffers();
			for(Offer offer : offers) {
				output.add(offer.getBuyer());
				
			}
			return output;
			}
		else {
			return null;
		}
	}
}
