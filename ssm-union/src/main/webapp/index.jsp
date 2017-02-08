<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
    <body>
        <h2>Hello World!</h2>
        <form action="${pageContext.request.contextPath}/students/showStudents.action"
              method="POST">
            学生ID：<input type="text" name="id" />
            <input type="submit" value="提交">
        </form>
    </body>
</html>
