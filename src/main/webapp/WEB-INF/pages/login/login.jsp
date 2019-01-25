<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <script type="text/javascript" src="../../../resources/js/lib/jquery.js"></script>


    <script type="application/javascript">
        /**
         * 表单置空
         */
        $("#reset").click(function () {
            $("username").val('');
            $("password").val('');
        });

        /**
         * 登录
         */
        $("#login").click(function () {
            $.ajax({
                url: '/login',
                type: 'post',
                cache: false,
                data: new FormData($('#uploadForm')[0]),
                processData: false,
                contentType: false
            }).done(function (res) {
            }).fail(function (res) {
            });
        });

        $("#pubsign").click(function () {
            $.ajax({
                url: '/pubsign',
                type: 'get',
                cache: false,
                data: new FormData($('#loginForm')[0]),
                processData: false,
                contentType: false
            }).done(function (res) {
            }).fail(function (res) {
            });
        });
    </script>
    <script type="text/javascript">
        $(document).ready(function () {
            pubsign();
        });
    </script>

</head>
<body>
<form id="loginForm" enctype="multipart/form-data">
    用户名:<input id="username" name="username" type="text"/><br/>
    密&nbsp;&nbsp;码:<input id="password" name="password" type="password"/>
    <button id="login" type="button">提交</button>
    <button id="reset" type="button">重置</button>
</form>
</body>
</html>