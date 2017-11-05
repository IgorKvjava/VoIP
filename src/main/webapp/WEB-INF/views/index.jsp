<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
<div class="blockIndex">
    <h2>LOGIN</h2>
    <form action="mainPageUser" method="POST" >
        <label>Your Login:
            <br>
        </label>
        <input type="text" name="login" value="${login}" size="15" maxlength="15"/>
        <br>
        <label>Your  Password :
            <br>
        </label>
        <input type="password" name="password" value="${password}"  size="15" maxlength="15"/>
        <p>
            <%-- <input type="hidden" name="do" value="login"/>--%>
            <input type="submit" name = "ok" value="Sign In" />
        </p>
    </form>
    <%--<button onclick="location.href = 'registration.jsp'">Sign Up</button>--%>

    <%--<form action="registrationPage" method="GET">
        <input type="submit" name="ok" value="Sign Up"/>
    </form>--%>
</div>
</body>
</html>