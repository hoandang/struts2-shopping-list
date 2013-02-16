<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv = "Content-Language" content = "en"/>
    <meta http-equiv = "Content-Type" content="text/html; charset=utf-8">
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/css/bootstrap-combined.min.css" rel="stylesheet">
    <link href="//netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" type="text/css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${contextPath}/assets/style.css"/>
    <%--<script src="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.0/js/bootstrap.min.js"></script>--%>
    <title>${pageTitle}</title>
</head>
<body>
    <div class="container">
        <div class="navbar">
            <div class="navbar-inner">
                <a href="${contextPath}" class="brand">SHOP</a>
                <ul class="nav">
                    <li class="active">
                        <a href="${contextPath}">Home</a>
                    </li>
                    <li>
                        <a href="${contextPath}/carts">Order</a>
                    </li>
                    <li>
                        <a href="#">Search Order</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="row-fluid">
