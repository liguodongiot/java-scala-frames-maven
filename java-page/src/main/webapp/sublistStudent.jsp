<%@ page language="java"
         contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
    <head>
        <meta http-equiv="Content-Type"
              content="text/html; charset=UTF-8">
        <title>学生信息</title>
    </head>
    <%
        // 获取请求的上下文
        String context = request.getContextPath();
    %>



<body>
<div style="margin-left: 100px; margin-top: 100px;">



    <%--JSP表单提交--%>
    <div>
        <form action="<%=context %>/sublistServlet"   id="stuForm"  method="post">
            姓名
            <input type="text" name="name" id="stu_name" style="width:120px" value="">
            &nbsp;
            性别
            <select name="gender" id="gender" style="width:80px">
                <option value="0">全部</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
            &nbsp;&nbsp;
            <input type="submit" value="查询">
        </form>
    </div>

    <br>
    学生信息列表：<br>
    <br>

    <!-- 后台返回结果为空 -->
    <c:if test="${fn:length(result.dataList) eq 0 }">
        <span>查询的结果不存在</span>
    </c:if>

    <!-- 后台返回结果不为空 -->
    <c:if test="${fn:length(result.dataList) gt 0 }">
        <table border="1px" cellspacing="0px"
               style="border-collapse: collapse">
            <thead>
            <tr height="30">
                <th width="130">姓名</th>
                <th width="130">性别</th>
                <th width="130">年龄</th>
                <th width="190">家庭地址</th>
            </tr>
            </thead>

            <c:forEach items="${result.dataList }" var="student">
                <tr>
                    <td><c:out value="${student.name }"></c:out></td>
                    <td>
                        <c:if test="${ student.gender eq 1 }">男</c:if>
                        <c:if test="${ student.gender eq 2 }">女</c:if>
                    </td>
                    <td><c:out value="${student.age }"></c:out></td>
                    <td><c:out value="${student.address }"></c:out></td>
                </tr>
            </c:forEach>

        </table>

        <br> 共${result.totalRecord }条记录&nbsp;&nbsp;共${result.totalPage }页&nbsp;&nbsp;当前第${result.currentPage }页&nbsp;&nbsp;
        <a href="#" onclick="firstPage();">首页</a>&nbsp;&nbsp;
        <a href="#" onclick="nextPage();">下一页</a>&nbsp;&nbsp;
        <a href="#" onclick="previousPage();">上一页</a>&nbsp;&nbsp;
        <a href="#" onblur="lastPage();">尾页</a>
    </c:if>
</div>
</body>
</html>