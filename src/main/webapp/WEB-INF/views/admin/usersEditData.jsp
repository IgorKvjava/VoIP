<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <script> <%@include file="/WEB-INF/views/js/product.js"%> </script>
    <title>PersonalProfile</title>
</head>
<body>
<div class="block">

        <table border="1" align="center" id="usersTable">
            <caption><s:message code="PersonalProfile"/></caption>

            <tr>
                <th><s:message code="id"/></th>
                <th><s:message code="login"/></th>
                <th><s:message code="password"/></th>
                <th><s:message code="userName"/></th>
                <th colspan="2"><s:message code="userRole"/></th>
            </tr>
            <%-- <c:forEach items="${listAllUsers}" var="listUsers">
                <tr>
                    <th>${listUsers.id}</th>
                    <th>${listUsers.login}</th>
                </tr>
            </c:forEach>--%>


            <c:forEach items="${listAllUsers}" var="listUsers">
                <tr >
                    <td>${listUsers.id} </td>
                    <td>${listUsers.login} </td>
                    <td>${listUsers.password} </td>
                    <td>${listUsers.userName} </td>
                    <td>${listUsers.role} </td>
                    <td>
                        <%--<button name="ok" onclick="deleteRow(this)">Delete</button>--%>
                        <input type="button" value="Delete" onclick="deleteRow(this)">
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>

    <br>
    <form action="/" method="GET">
        <input type="submit" name="ok" value="Exit"/>
    </form>
</div>
</body>
</html>
