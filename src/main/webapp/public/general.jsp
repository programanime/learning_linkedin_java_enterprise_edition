<html>
<head><title>First JSP</title></head>
<body>
    <p>some random number</p>
    <%
        String name = "rick";
    %>

    <p>
        Hello  <%= name %>
    </p>

    <p>
        Hello  ${2 * 3}
    </p>

    <%
        double num = Math.random();
        if (num > 0.95) {
    %>
        <h2>You'll have a luck day!</h2><p>(<%= num %>)</p>
    <%
        } else {
    %>
        <h2>Well, life goes on ... </h2><p>(<%= num %>)</p>
    <%
        }
    %>
    <a href="<%= request.getRequestURI() %>">
        <h3>Try Again</h3>
    </a>


</body>
</html>