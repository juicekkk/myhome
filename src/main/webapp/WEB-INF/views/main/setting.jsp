<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>MAIN</p>
        <p>SUB 내용이 표시됩니다<br>내가 좋아하는 글이나 나만의 글을 작성해보아요 !</p>
    </div>

    <div class="joinWrap">
        <div class="joinContentsWrap">

            <div class="joinContent">
                <select name="cate" id="settingCate">
                    <option value="">선택</option>
                    <option value="1">EAT</option>
                    <option value="2">HOBBY</option>
                    <option value="3">TRAVEL</option>
                    <option value="4">DAILY</option>
                    <option value="5">ETC</option>
                </select>
            </div>

            <div class="joinContent">
                <label>MAIN</label>
                <input type="text" name="mainTitle" id="mainTitle">
            </div>

            <div class="joinContent">
                <label>SUB</label>
                <textarea name="subTitle" id="subTitle"></textarea>
            </div>

        </div>

        <div class="modifyBtnWrap">
            <a><input type="button" value="변경"></a>
        </div>
    </div>

</div>