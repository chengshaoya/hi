<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<body>
 <c:if test="false" var="aaa" scope="session">
   		测试if标签，var属性:${aaa }
   </c:if>
 <%--  pageScope: ${pageScope.aaa }
 sessionScope： ${sessionScope.aaa } --%>
<c:set ></c:set>
</body>
</html>
