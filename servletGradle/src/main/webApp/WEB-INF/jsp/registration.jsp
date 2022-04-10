<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <img src="${pageContext.request.contextPath}/images/users/avatar.png" alt="user photo">
  <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
      <input type="text" name="username" id="username" placeholder="name" required><br>
      <input type="date" name="birthday" id="birthday" aria-placeholder="birthday" required><br>
      <label for="imageId">Photo:
          <input type="file" name="image" id="imageId">
      </label><br>
      <input type="email" name="email" id="email" placeholder="email" required><br>
      <input type="password" name="password" id="password" placeholder="password" required><br>
      <select name="role" id="role">
          <c:forEach var="role" items="${requestScope.roles}" >
              <option value="${role}">${role}</option>
          </c:forEach>
      </select><br>
      <c:forEach var="gender" items="${requestScope.genders}">
          <input type="radio" name="gender" value="${gender}"> ${gender}
          <br>
      </c:forEach>
      <button type="submit">sign up</button><br>

      <c:if test="${not empty requestScope.errors}">
          <div style="color: red">
              <c:forEach var="error" items="${requestScope.errors}">
                  <span>${error.message}</span>
                  <br>
              </c:forEach>
          </div>
      </c:if>
  </form>
</body>
</html>
