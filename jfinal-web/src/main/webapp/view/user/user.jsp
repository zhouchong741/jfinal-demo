<%--
  Created by IntelliJ IDEA.
  User: zc741
  Date: 2017/4/23
  Time: 2:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user</title>
</head>
<body>
<#list userList as count>hehehe</#list>
<div>当前人数：${count}</div>
<div>
    username:<input class="name" placeholder="username">
    password:<input class="pwd" placeholder="password">
    <button class="save">submit</button>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.js"></script>
<script>
    $(".save").click(function () {
        var data = {};
        data.username = $(".name").val();
        data.password = $(".pwd").val();
        $.ajax({
            url: 'user/saveUser',
            dataType: "json",
            data: data,
            complete: function (result) {
                console.log(result);
            }
        });
    })

</script>
</body>
</html>
