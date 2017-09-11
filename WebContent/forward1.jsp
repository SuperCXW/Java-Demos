<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>Request对象实现请求转发</title>
  </head>
  
  <body>
      <h3 style="color:red;"><%=(String)request.getAttribute("data")%></h3>
     <h3 style="color:red;">${data}</h3>
  </body>
</html>