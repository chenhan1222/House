<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<form action="selectHouseBySname" method="post" target="right">
    <select name="sname" style="width: 350px;height: 50px;margin-top:12px">
        <c:forEach items="${Sort}" var="s">
            <option value="${s.sname }">${s.sname}</option>
        </c:forEach></select>
    <input type="submit" value="搜索" style="width: 150px;height:50px;background-color: #fed243">
</form>
</body>
</html>