<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <title>PersonalProfile</title>
</head>
<body>
<div class="block">
    <form action="usersUpdateData" method="post">
        <table border="1" align="center">
            <caption><s:message code="PersonalProfile"/></caption>

            <tr>
                <th><s:message code="id"/></th>
                <th><s:message code="login"/></th>
                <th><s:message code="password"/></th>
                <th><s:message code="userName"/></th>
                <th><s:message code="userRole"/></th>
            </tr>
            <%-- <c:forEach items="${listAllUsers}" var="listUsers">
                <tr>
                    <th>${listUsers.id}</th>
                    <th>${listUsers.login}</th>
                </tr>
            </c:forEach>--%>
            <c:forEach items="${listAllUsers}" var="listUsers">
                <tr>
                    <th>${listUsers.id} </th>
                    <th>${listUsers.login} </th>
                    <th>${listUsers.password} </th>
                    <th>${listUsers.userName} </th>
                    <th>${listUsers.role} </th>
                </tr>
            </c:forEach>
        </table>
        <input type="submit" name="ok" value="Update data"/>
    </form>
    <br>
    <form action="/" method="GET">
        <input type="submit" name="ok" value="Exit"/>
    </form>

</div>
</body>
</html>
