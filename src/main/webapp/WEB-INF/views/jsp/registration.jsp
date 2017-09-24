c<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
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
<%@ include file="header.jsp" %>
	<h3><center>Join here to BID your items</center></h3>
	<div id="registration">
	<center>
		<form action="register" method="post">
		<table>
			<tr><td><h4>NetId </h4></td><td><input type="text" name="netId" placeholder="Username" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>FirstName </h4></td><td><input type="text" name="firstName" placeholder="Firstname" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>LastName </h4></td><td><input type="text" name="lastName" placeholder="Lastname" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Password </h4></td><td><input type="password" name="password" placeholder="Aa123!@#$%" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>PhoneNumber </h4></td><td><input type="text" name="phoneNumber" placeholder="PhoneNumber" size="10" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Email </h4></td><td><input type="text" name="email" placeholder="Example@mail.com" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>StreetName </h4></td><td><input type="text" name="streetName" placeholder="user's streetName" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>Apartment Number </h4></td><td><input type="text" name="AptNo" placeholder="user's HouseNumber" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>City </h4></td><td><input type="text" name="city" placeholder="user's City" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>State </h4></td><td><input type="text" name="state" placeholder="user's state" size="14" required="true" autocomplete="off"></td></tr>
			<tr><td><h4>PinCode </h4></td><td><input type="text" name="pinCode" placeholder="user's pincode" size="14" required="true" autocomplete="off"></td></tr>
		</table>
			<input type="submit" value="register">
			<a href="newuserlogin">Already a user! Login here</a>
		</form>
	</center>
	</div>

<%@ include file="footer.jsp" %>
</body>
</html>