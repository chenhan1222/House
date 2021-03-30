<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>
<div class="panel-head"><strong class="icon-reorder"> 删除房屋信息</strong></div>
<table class="table table-hover text-center" style="width: 100%">
    <tr>
        <th>房屋ID</th>
        <th>房屋名称</th>
        <th>房屋图片</th>
        <th>房屋面积</th>
        <th>所在小区</th>
        <th>装修状况</th>
        <th>房屋价钱</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${House}" var="h">
        <tr>
            <td>${h.hid }</td>
            <td><img src='images/${h.photo }' style="width: 100px;height: 100px"></td>
            <td>${h.hname }</td>
            <td>${h.housearea }</td>
            <td>${h.village }</td>
            <td>${h.housezx }</td>
            <td>${h.price }</td>
            <td>
                <div class="button-group"><a href="deleteHouseByID?hid=${h.hid}" onclick="return confirm('确定要删除吗！')"
                                             class="button border-red" href="javascript:void(0)"
                                             onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a></div>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
