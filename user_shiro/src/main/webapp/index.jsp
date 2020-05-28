<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" %>

<html>
<body>
<h2>Hello World!</h2>
<div class="error">${error}</div>
<form action="${pageContext.request.contextPath}/userlogin" method="post">
   <label for="user-name-label">用户名</label> <input type="text" name="username" id="user-name-label"><br/>
    <label for="password-label">密码</label><input type="password" name="password" id="password-label"><br/>
    <input type="submit" value="登录">
</form>
</body>
</html>
