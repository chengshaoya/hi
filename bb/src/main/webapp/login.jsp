<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="loginForm" method="post" action="judgeUser.jsp">
    <table>
      <tr>
        <td>用户名:<input type="text" name="userName" id="userName"></td>
      </tr>
      <tr>
        <td>密码:<input type="password" name="password" id="password"></td>
      </tr>
      <tr>
        <td><input type="submit" value="登录" style="background-color:pink">  <input type="reset" value="重置" style="background-color:red"></td>     
      </tr>
    </table>
  </form>

</body>
</html>