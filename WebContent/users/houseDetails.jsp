<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>

    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
</head>
<body>

<div style="width: 1100px;margin-top: 5px;text-align:center;background-color: white;margin-left: 100px">

    <img src='images/${House.photo}' style="width: 300px;height: 230px;float: left;"><br>
    <div style="width: 800px;height: 220px;float: left;">

        <b style="font-family: 宋体;color:red">${House.price}/元</b><br><br>
        <b style="font-family: 宋体;">${House.hname}</b><br><br>
        <b style="font-family: 宋体;">面积：${House.housearea}</b>&nbsp;&nbsp;&nbsp;
        <b style="font-family: 宋体;">总楼层：${House.housezlc}</b>&nbsp;&nbsp;&nbsp;
        <b style="font-family: 宋体;">所在楼层：${House.houseszlc}</b><br><br>
        <b style="font-family:宋体">小区名称：${House.village}</b><br><br>
        <b style="font-family:宋体">小区地址：${House.address}</b><br><br>
        <b style="font-family:宋体">房源介绍：${House.introd}</b><br><br>

    </div>
</div>
<div class="panel admin-panel" style="clear: left; ">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>进行租赁</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="addOrders">
            <input type="hidden" class="input" name="price" value='${House.price}'/>
            <input type="hidden" class="input" name="hid" value='${House.hid}'/>
            <div class="form-group">
                <div class="label">
                    <label>联系人：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="username" data-validate="required:请输入联系人"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>联系电话：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="telephone" data-validate="required:请输入联系电话"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>身份证号：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="idcard" data-validate="required:请输入身份证号"/>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>租赁月数：</label>
                </div>
                <div class="field">
                    <input type="number" class="input" name="nums" data-validate="required:请输入租赁月数"/>
                </div>
            </div>

            <div style="padding-left: 40%;" class="field">
                <button class="button bg-main icon-check-square-o" type="submit">租赁</button>
                <button class="button bg-main icon-check-square-o" type="reset"> 取消</button>
            </div>
    </div>
    </form>
</div>
</body>
</html>