<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<div class="contentsWrap">

    <div class="mainWord">
        <h2 class="subtitle">How was your today ?</h2>
        <h1 class="title">LOGUE YOUR <span class="emphasis">DAILY LIFE</span></h1>
    </div>

    <div class="mainIcons">
        <div class="mainIcon">
            <a href="/eat.do"><img src="${path}/resources/images/mainIcon1.png" style="width: 55px; margin-top: 15px;"></a>
        </div>
        <div class="mainIcon">
            <a href="/hobby.do"><img src="${path}/resources/images/mainIcon2.png"></a>
        </div>
        <div class="mainIcon">
            <a href="/travel.do"><img src="${path}/resources/images/mainIcon4.png" style="width: 90px; margin-top: 10px;"></a>
        </div>
        <div class="mainIcon">
            <a href="/daily.do"><img src="${path}/resources/images/mainIcon3.png" style="width: 85px; margin-top: 10px; height: 90px;"></a>
        </div>
    </div>

</div>
