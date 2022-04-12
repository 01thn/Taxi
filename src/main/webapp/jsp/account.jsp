<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
</head>
    <c:if test="${not empty message}">
        ${message}
    </c:if>
<body>
    <form method="post" action="confirm-order">
        <label for="order-from">Input the place of start</label>
        <input type="text" id="order-from" name="order-from" placeholder="Minsk, Surhanava, 28">
        <label for="order-to">Input the place of end</label>
        <input type="text" id="order-to" name="order-to" placeholder="Minsk, Niamiha, 3">
        <input type="submit" value="Confirm order">
    </form>
</body>
</html>
