<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>이방인</p>
        <p>그제야 나는 알게 될지 몰라<br>그토록 찾아 헤매던<br>나의 머물곳이 너였음을</p>
    </div>

    <div class="findWrap">
        <div class="findContentsWrap">
            <div class="findContent">
                <div class="find">
                    <label>닉네임</label>
                    <input type="text" name="nickName" id="nickName" placeholder="NICKNAME">
                </div>
                <div class="find">
                    <label>이메일</label>
                    <input type="text" name="email1" id="email1" placeholder="EMAIL">
                    <span style="display: flex; flex-wrap: wrap; align-items: center;">@</span>
                    <select name="email2" id="email2">
                        <option value="">선택</option>
                        <option value="naver.com">naver.com</option>
                        <option value="gmail.com">gmail.com</option>
                    </select>
                </div>

                <div class="findBtnWrap">
                    <a><input type="button" value="아이디찾기"></a>
                </div>
            </div>

            <div class="findContent">
                <div class="find">
                    <label>아이디</label>
                    <input type="text" name="userId" id="userId" placeholder="ID">
                </div>
                <div class="find">
                    <label>질문</label>
                    <select name="question" id="question" style="margin: 0px;">
                        <option value="">비밀번호찾기 시 사용</option>
                        <option value="1">나의 보물 1호는 무엇인가요?</option>
                        <option value="2">어머니 성함은 무엇인가요?</option>
                        <option value="3">아버지 성함은 무엇인가요?</option>
                        <option value="4">학창시절 별명은 무엇인가요?</option>
                        <option value="5">나의 학교 이름은 무엇인가요?</option>
                    </select>
                </div>
                <div class="find">
                    <label>답변</label>
                    <input type="text" name="answer" id="answer">
                </div>

                <div class="findBtnWrap">
                    <a><input type="button" value="비밀번호찾기"></a>
                </div>
            </div>
        </div>
    </div>

</div>