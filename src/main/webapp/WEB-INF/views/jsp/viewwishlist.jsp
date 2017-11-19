<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "com.cometsale.model.ProductDetails" %>
<%@ page import = "com.cometsale.mongodb.ProductDB" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>My Wish List</title>
<link href="resources/css/bootstrap-combined.min.css" rel="stylesheet" id="bootstrap-css">
<style>
#registration{
  display: flex;
  min-height: 100vh;
  flex-direction: column;
}
</style>
    <script src="resources/js/jquery-1.10.2.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
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
                   <a href="#" class="logo" title="Back to homepage"><img src="resources/images/CometSaleLogo_2.png" height="200px" width="200px" alt="logo"></a>
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
                            <a href="homepage">Home</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="addProduct">Add Product</a>
                        </li>
						<li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="viewProfile">View Profile</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="viewWishlist">View Wishlist</a>
                        </li>
                        <li><h5>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</h5></li>
                        <li>
                            <a href="contactus">Contact Us</a>
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
                        <form id="search" style="margin:9px" action="availableauctions">
                        <a href="#" style="color:#777777">Search</a>
                        <input type="text">
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
                  
                  <th>Product Image</th>
                  <th>Product Name</th>
                  <th>Product Desc</th>
                  <th>Price Offered</th>
                  <th>Status</th>
				  <th>Quality</th>
				  <th>Category</th>
				  <th>Street Name</th>
                  <th>City</th>
                  <th>State</th>
                  <th>PinCode</th>
                  <th>Remove from WishList</th>
                  <th>Lock the Product</th>				  
                </tr>
                
                </table>
            
            <table id="table2" class="sortable, mytable, table table-striped ">
            	<tr style="display:none;">
              
                  <th></th>
                  
                  <th>Product Image</th>
                  <th>Product Name</th>
                  <th>Product Desc</th>
                  <th>Price Offered</th>
                  <th>Status</th>
				  <th>Quality</th>
				  <th>Category</th>
				  <th>Street Name</th>
                  <th>City</th>
                  <th>State</th>
                  <th>PinCode</th>
                  <th>Remove from WishList</th>
                  <th>Lock the Product</th>				  
                </tr>
        <% 
        ArrayList<ProductDetails> records = new ArrayList<ProductDetails>();
        records = ProductDB.fetchAll();
        for(int i=0;i<records.size();i++){
        %>
        <tr>
      	<td name = "image" ><img src="imageController/<%out.println(records.get(i).getProductID());%>" width="80"height="80"></img></td>
      	<td name ="productName" value=<%records.get(i).getProductName();%>><%out.print(records.get(i).getProductName());%></td>      	
      	<td name ="productDesc" value=<%records.get(i).getProductDesc();%>><%out.print(records.get(i).getProductDesc());%></td>      	
      	<td name ="offerPrice" value=<%records.get(i).getOfferPrice();%>><%out.print(records.get(i).getOfferPrice());%></td>      	
      	<td name ="status" value=<%records.get(i).getStatus();%>><%out.print(records.get(i).getStatus());%></td> 
      	<td name ="quality" value=<%records.get(i).getQuality();%>><%out.print(records.get(i).getQuality());%></td>      	
      	<td name ="category" value=<%records.get(i).getCategory();%>><%out.print(records.get(i).getCategory());%></td>
      	<td name ="streetName" value=<%records.get(i).getPickupAddress().getStreetname();%>><%out.print(records.get(i).getPickupAddress().getStreetname());%></td>
      	<td name ="city" value=<%records.get(i).getPickupAddress().getCity();%>><%out.print(records.get(i).getPickupAddress().getCity());%></td>
      	<td name ="state" value=<%records.get(i).getPickupAddress().getState();%>><%out.print(records.get(i).getPickupAddress().getState());%></td>
      	<td name ="pinCode" value=<%records.get(i).getPickupAddress().getPinCode();%>><%out.print(records.get(i).getPickupAddress().getPinCode());%></td>
      	<td name="removeFromWishlist"><a href="removeFromWishlist">Remove From Wishlist</a></td>
      	<td name ="lockProduct"><a href="lockProduct">Lock the Product</a></td>
      	<br>
      	<%
      	}
      	%>
      	</div>
      </div>
    </div>
  </div>
</div>

</body>
</html>