<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <input type="text" name="email" id="email" placeholder="email" required><br>
        <input type="password" name="password" id="password" placeholder="password" required><br>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Register</button>
        </a>
        <div>
            <c:if test="${param.error != null}">
                <div style="color: red">
                    <span>Email or password is not correct</span>
                </div>
            </c:if>
        </div>
    </form>
</body>
</html>
