package com.cometsale.model;

import java.util.ArrayList;

import com.cometsale.mongodb.ProductDB;

public class SupplierHelper {
	
	
	public void postProduct(){
		
	}
	
	public void closeProduct(Student seller,Product p) {
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
			p.setStatus(ProductStatus.closed);
			ProductDB.updateStatus(p);
		}
	}

	public void lockProduct(Student seller,Product p) {
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
			p.setStatus(ProductStatus.locked);
			ProductDB.updateStatus(p);
		}
	}

	
	public ArrayList<Student> fetchOfferedBuyer(Student seller,Product p){
		
		if(p.getSeller().getNetid().equals(seller.getNetid())) {
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
