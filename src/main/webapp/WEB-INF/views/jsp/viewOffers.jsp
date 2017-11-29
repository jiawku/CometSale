<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.cometsale.model.Product" %>
<%@ page import = "com.cometsale.model.Student" %>
<%@ page import = "com.cometsale.mongodb.ProductDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import = "com.cometsale.mongodb.UserDB" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Offers</title>
<link href="/CometSale/resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<style>
#registration{
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>
    <script src="/CometSale/resources/js/jquery-1.10.2.min.js"></script>
    <script src="/CometSale/resources/js/bootstrap.min.js"></script>
    <script type="text/javascript">
        window.alert = function(){};
        var defaultCSS = document.getElementById('bootstrap-css');
        function changeCSS(css){
            if(css) $('head > link').filter(':first').replaceWith('<link rel="stylesheet" href="'+ css +'" type="text/css" />'); 
            else $('head > link').filter(':first').replaceWith(defaultCSS); 
        }
        
    </script>
</head>
<body>
<!-- header-->
<div class="container">
  <div class="row">
    <div class="span12">
      <div class="head">
        <div class="row-fluid">
            <div class="span12">
             <div class="span6">
              <h3 class="muted">
                   <a href="#" class="logo" title="Back to homepage"><img src="/CometSale/resources/images/CometSaleLogo_2.png" height="200px" width="200px" alt="logo"></a>
              </h3>
          </div>
        </div>
      </div>
    </div>
  </div>
 </div>
</div>

<div class="navbar">
            <div class="navbar-inner">
                <div class="container">
                    <ul class="nav">
                        <li>
                            <a href="/CometSale/homepage">Home</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="/CometSale/addProduct">Add Product</a>
                        </li>
						<li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="/CometSale/viewProfile">View Profile</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="/CometSale/viewWishlist">View WishList</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="/CometSale/contactus">Contact Us</a>
                        </li>
                        
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        
                        <li>
                        <form id="search" style="margin:9px" action="search">
                        <a href="#" style="color:#777777">Search</a>
                        <input name="searched" type="text">
                        </form>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="logout">Logout</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <div>
        <div class="table-responsive">
          <table class="  mytable, table table-striped ">
          <col width="130"><col width="130"><col width="200"><col width="130"><col width="130"><col width="130"><col width="130"><col width="130"><col width="130"><col width="130"><col width="130"><col width="130">
           		
            <tr>
                  
                  <th>Seller's NetID</th>
                  <th>First Name</th>
                  <th>City</th>
                  <th>Pincode</th>
                  <th>State</th>
				  <th>Streetname</th>
				  <th>Last Name</th>
				  <th>Phone Number</th>
                  <th>Seller's Email</th>
                </tr>
                
                </table>
            
            <table id="table2" class="sortable, mytable, table table-striped ">
            	<tr style="display:none;">
              
                  <th></th>
                  
                  <th>Seller's NetID</th>
                  <th>First Name</th>
                  <th>City</th>
                  <th>Pincode</th>
                  <th>State</th>
				  <th>Streetname</th>
				  <th>Last Name</th>
				  <th>Phone Number</th>
                  <th>Seller's Email</th>				  
                </tr>
        <% 
        session = request.getSession();
        String netID = session.getAttribute("NetID").toString();
        
        ArrayList<Student> findResult= UserDB.find(netID,"netid");
        System.out.println(findResult.get(0).getNetid());
		if(findResult==null){
			//TODO: handle user not found.
			System.out.println("User Not found!");
		}
		
		Student user = findResult.get(0);
		
        ArrayList<Product> records = new ArrayList<Product>();
        records = ProductDB.fetchAll();
        for(int i=0;i<records.size();i++){
        	if ((records.get(i).getSeller()!=null ) && (records.get(i).getSeller().getNetid().equals(user.getNetid()))){
        %>
        <tr>
      	<td name ="firstName" value=<%records.get(i).getProductDetails().getProductName();%>><%out.print(records.get(i).getProductDetails().getProductName());%></td>      	
      	<td name ="city" value=<%records.get(i).getProductDetails().getProductDesc();%>><%out.print(records.get(i).getProductDetails().getProductDesc());%></td>      	
      	<td name ="pinCode" value=<%records.get(i).getProductDetails().getOfferPrice();%>><%out.print(records.get(i).getProductDetails().getOfferPrice());%></td>      	
      	<td name ="state" value=<%records.get(i).getStatus();%>><%out.print(records.get(i).getStatus());%></td> 
      	<td name ="streetName" value=<%records.get(i).getProductDetails().getQuality();%>><%out.print(records.get(i).getProductDetails().getQuality());%></td>      	
      	<td name ="lastName" value=<%records.get(i).getProductDetails().getCategory();%>><%out.print(records.get(i).getProductDetails().getCategory());%></td>
      	<td name ="phoneNumber" value=<%records.get(i).getProductDetails().getPickupAddress().getStreetname();%>><%out.print(records.get(i).getProductDetails().getPickupAddress().getStreetname());%></td>
      	<td name ="email" value=<%records.get(i).getProductDetails().getPickupAddress().getCity();%>><%out.print(records.get(i).getProductDetails().getPickupAddress().getCity());%></td>
      	<br>
      	<%
        	}}
      	%>
      	</div>
      </div>
    </div>
  </div>
</div>

</body>
</html>
