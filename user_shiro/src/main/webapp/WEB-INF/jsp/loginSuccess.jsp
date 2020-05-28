<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>
<html>
<head>
    <title></title>
</head>
<body>
欢迎${subject.principal}登录成功！
<form action="${pageContext.request.contextPath}/updateUser" method="post">
    <label for="user-name-label">用户名</label> <input type="text" name="username" id="user-name-label"><br/>
    <label for="password-label">密码</label><input type="password" name="password" id="password-label"><br/>
    <input type="submit" value="修改账户密码">
</form>
</body>
</html>