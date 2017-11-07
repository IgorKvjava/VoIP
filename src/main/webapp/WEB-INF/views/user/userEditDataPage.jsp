<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <title>PersonalProfile</title>
</head>
<body>
<div class="block">
    <form action="userUpdateData" method="post">
    <table border="1" align="center">
        <caption><s:message code="PersonalProfile"/></caption>

        <tr>
            <th><s:message code="id" /></th>
            <th><s:message code="login"/></th>
            <th><s:message code="password"/></th>
            <th><s:message code="userName"/></th>
            <th><s:message code="userRole"/></th>
        </tr>
        <tr>
            <th>${user.id}  </th>
            <th>${user.login}   </th>
            <th><input type="text" name="password" value="${user.password}"/>   </th>
            <th><input type="text" name="userName" value="${user.userName}"/>   </th>
            <th>${user.role} </th>
        </tr>
    </table>
        <input type="submit" name = "ok" value="Update data" />
    </form>
    <br>
    <form action="/" method="GET">
        <input type="submit" name="ok" value="Exit"/>
    </form>
    <%--<form action="userEditData" method="POST">
        <table border="1" align="center">
            <caption>PersonalProfile</caption>
            <tr>
                <th>ID</th>
                <th>Login</th>
                <th>Password</th>
                <th>Name</th>
                <th>role</th>
            </tr>
            <tr>
                <td>${sessionScope.registeredUser.id}
                </td>
                <td>${sessionScope.registeredUser.login}
                </td>
                <td><input type="text" name="password" value="${sessionScope.registeredUser.password}"/>
                </td>
                <td><input type="text" name="name" value="${sessionScope.registeredUser.userName}"/>
                </td>
                <td>${sessionScope.registeredUser.role}
            </tr>
        </table>
        <p>
            <input type="submit" value="Edit"/>
        </p>
    </form>--%>
</div>
</body>
</html>
