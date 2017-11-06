<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <style>
        <%@include file='/WEB-INF/views/css/style.css' %>
    </style>
</head>
<body >
<div>
    <s:message code="Language"/> : <a href="?lang=en"><s:message code="ENG"/></a> | <a href="?lang=ru"><s:message code="RUS"/></a>
    <%--<table>
        <th>
            <form action="?lang=ru" method="post">
                <input type="submit" value="<s:message code="RUS"/>"/>
            </form>
        </th>
        <th>
            <form action="?lang=en" method="post">
                <input type="submit" value="<s:message code="ENG"/>"/>
            </form>
        </th>
    </table>
    Current Locale : ${pageContext.response.locale} / ${locale}--%>
</div>
</body>
</html>
