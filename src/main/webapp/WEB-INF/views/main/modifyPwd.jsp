<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>기록</p>
        <p>그래서 사람들은 기록한다<br>행복을 다시 꺼내보기 위해<br>행복했던 순간들을 다시 살기 위해</p>
    </div>

    <div class="joinWrap">
        <div class="joinContentsWrap">
            <div class="joinContent">
                <label>변경 전</label>
                <input type="password" name="userPwd" class="userPwd" placeholder="CURRENT PASSWORD">
            </div>
            <div class="joinContent">
                <label>변경 후</label>
                <input type="password" name="newUserPwd" class="userPwd" placeholder="NEW PASSWORD">
            </div>
        </div>
        <div class="joinBtnWrap">
            <a><input type="button" value="변경"></a>
        </div>
    </div>

</div>