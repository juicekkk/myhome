<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>제목</title>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="${path}/resources/js/common.js"></script>
    <link href="${path}/resources/css/main.css" rel="stylesheet"/>
</head>
<body>
<div style="width:100%; height:100%;">
    <div class="backgroundTop"></div>

    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="left" class="for_m"><tiles:insertAttribute name="left" /></div>
    <div id="main"><tiles:insertAttribute name="body" /></div>
    <div id="footer"><tiles:insertAttribute name="footer" /></div>

    <div class="backgroundBottom"></div>
</div>

<script type="text/javascript">
    $(function() {

    });
</script>
</body>
</html>