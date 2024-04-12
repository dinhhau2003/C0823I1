<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<!-- index.jsp -->
<form action="calculate-discount" method="post">
    <label for="productDescription">Product Description:</label>
    <input type="text" id="productDescription" name="productDescription"><br>
    <label for="listPrice">List Price:</label>
    <input type="number" id="listPrice" name="listPrice"><br>
    <label for="discountPercent">Discount Percent:</label>
    <input type="number" id="discountPercent" name="discountPercent"><br>
    <button type="submit">Calculate Discount</button>
</form>
</body>
</html>