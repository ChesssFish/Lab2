<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Login</title>
</head>
<body>
   <form action="login" method="post">
      User:<br/><input type="text" name="user" value="test"/><br/>
      Password:<br/><input type="password" name="password" value="000000"/><br/>
      <input type="submit" value="Login"/>		
   </form>
   
	<s:url var="testUrlId" action="delete">
	    <s:param name="isbn">0000-0000-0000-0000</s:param>
	</s:url>
	<s:a href="%{testUrlId}">
	   	delete
	</s:a>
</body>
</html>