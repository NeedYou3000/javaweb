<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/25/2022
  Time: 9:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Dashboard - SB Admin</title>
    <link href="<c:url value="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" />" rel="stylesheet" />
    <link href="<c:url value="/templates/admin/css/styles.css"/>" rel="stylesheet" />
    <script src="<c:url value="https://use.fontawesome.com/releases/v6.1.0/js/all.js"/>" crossorigin="anonymous"></script>
</head>
<body class="sb-nav-fixed">
    <%@include file="/commons/admin/header.jsp"%>
    <div id="layoutSidenav_content">
        <sitemesh:write property='body'/>
        <%@include file="/commons/admin/footer.jsp"%>
    </div>
</div>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"/>" crossorigin="anonymous"></script>
<script src="<c:url value="/templates/admin/js/scripts.js"/>"></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js"/>"></script>
<script src="<c:url value="/templates/admin/assets/demo/chart-area-demo.js"/>"></script>
<script src="<c:url value="/templates/admin/assets/demo/chart-bar-demo.js"/>"></script>
<script src="<c:url value="https://cdn.jsdelivr.net/npm/simple-datatables@latest"/>"></script>
<script src="<c:url value="/templates/admin/js/datatables-simple-demo.js"/>"></script>
</body>
</html>

