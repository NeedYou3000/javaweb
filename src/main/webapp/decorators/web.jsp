<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/25/2022
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Small Business - Start Bootstrap Template</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<c:url value="/templates/web/assets/favicon.ico"/>" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="<c:url value="/templates/web/css/styles.css"/>" rel="stylesheet" />
</head>
<body>
<!-- Responsive navbar-->
<%@include file="/commons/web/header.jsp"%>
<!-- Page Content-->
<sitemesh:write property='body'/>
<!-- Footer-->
<%@include file="/commons/web/footer.jsp"%>
<!-- Bootstrap core JS-->
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"/>"></script>
<!-- Core theme JS-->
<script src="<c:url value="/templates/web/js/scripts.js"/>"></script>
</body>
</html>

