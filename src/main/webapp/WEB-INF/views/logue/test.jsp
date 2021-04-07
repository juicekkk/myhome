<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div class="boardWrap type2">

    <div class="titleWrap">
        <p>TEST TITLE</p>
        <p>TEST SUB TITLE ...</p>
    </div>

    <div class="contents">
        <div class="empty">TEST</div>
        <c:forEach items="${testpage}" var="testpage">
            <tr>
                <td>${testpage.testColumn}</td>
            </tr>
        </c:forEach>
    </div>



</div>