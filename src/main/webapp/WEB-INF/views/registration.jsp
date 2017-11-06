<%@include file="/WEB-INF/views/header.jsp" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<div class="block">

    <c:set var="urladdr" value="userRegistration"/>
    <%--Spring form. modelAttribute value is important --%>
    <sf:form modelAttribute="registeredUser" action="${urladdr}">
        <%--spring label--%>
        <label for="userName">
            <s:message code="enterYourName"/>
        </label>
        <%--spring input text--%>
        <sf:input path="userName"/>
        <sf:errors path="userName" cssClass="error"/>
        <br>
        <label for="login">
            <s:message code="enterYourLogin"/>
        </label>
        <sf:input path="login"/>
        <sf:errors path="login" cssClass="error"/>
        <br>
        <label for="password">
            <s:message code="enterYourPassword"/>
        </label>
        <sf:input path="password"/>
        <sf:errors path="password" cssClass="error"/>
        <br>
        <%--not spring button--%>
        <button type="submit" name="Send">
            <s:message code="sendToRegister"/>
        </button>
    </sf:form>

    <form action="/" method="GET">
        <input type="submit" name="ok" value="Exit"/>
    </form>
</div>
</body>
</html>
