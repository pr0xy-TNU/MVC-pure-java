<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Your search result</title>
</head>
<body>
<h1 align="center">Recommended beer for you</h1>

<ul>
    <c:forEach items="${requestScope.beers}" var="beer">
        <li>${beer}</li>
    </c:forEach>
</ul>
</body>
</html>
