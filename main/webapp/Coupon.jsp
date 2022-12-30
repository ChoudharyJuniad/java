<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Coupon</h1>
<form action="coupons" method="post">
<pre>
Coupon code:<input type="text" name="coupon_Code"/>
Discount:<input type="text" name="discount"/>
ExpDate:<input type="text" name="expdate"/>
<input type="hidden" name="action" value="create"/>
<input type="submit" value="save"/>
</form>
</pre>
</body>
</html>