<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="panel admin-panel">
    <div class="panel-head" id="add"><strong><span class="icon-pencil-square-o"></span>添加房屋信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="addHouse" enctype="multipart/form-data">
            <div class="form-group">
                <div class="label">
                    <label>房屋图片：</label>
                </div>
                <div class="field">
                    <input type="file" name="file">
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="hname"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋面积：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="housearea"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋楼层：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="housezlc"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>所在楼层：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="houseszlc"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋装修：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="housezx"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>小区名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="village"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>详细地址：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="address"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋介绍：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" value="" name="introd"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>租金/月：</label>
                </div>
                <div class="field">
                    <input type="number" class="input" value="" name="price"/>
                    <div class="tips"></div>
                </div>
            </div>
            <div class="form-group">
                <div class="label">
                    <label>房屋户型：</label>
                </div>
                <div class="field">
                    <select name="sname" style="width: 900px;height: 55px">
                        <c:forEach items="${Sort}" var="s">
                            <option value="${s.sname }">${s.sname}</option>
                        </c:forEach></select>
                    <div class="tips"></div>
                </div>
            </div>


            <div style="padding-left: 40%;" class="field">
                <button class="button bg-main icon-check-square-o" type="submit">保存</button>
                <button class="button bg-main icon-check-square-o" type="reset"> 取消</button>
            </div>
    </div>
    </form>
</div>


</body>
</html>