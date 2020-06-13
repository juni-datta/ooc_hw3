<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<title>Create an account</title>
<body>
<p>
    ${error}
</p>
<h2>
    Pick a username and password
</h2>
<p>
<form action="/signup" method="post">
    <input type="text" placeholder="Enter Username" name="username" required><br>
    <input type="password" placeholder="Enter Password" name="password" required><br>
    <button type="submit">Create account</button>
</form>
</p>

</body>
</html>