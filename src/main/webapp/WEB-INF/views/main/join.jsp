<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>이름이 없으면</p>
        <p>꽃을 보려거든, 이름 없이 태어나라<br>봄 한 시절에 피는 저게 무슨 꽃인지 나는<br>그해 여름이 되어서야 알게 되었다</p>
    </div>

    <div class="joinWrap">
        <div class="joinContentsWrap">
            <div class="joinContent">
                <label>아이디</label>
                <input type="text" name="userId" id="userId" placeholder="ID">
                <a href="#"><input type="button" value="중복체크" id="dupliChk" style="width: 80px;"></a>
            </div>
            <div class="joinContent">
                <label>비밀번호</label>
                <input type="password" name="userPwd" class="userPwd" placeholder="PASSWORD">
            </div>
            <div class="joinContent">
                <label>비밀번호</label>
                <a href="/modify/pwd.do" id="pwdModifyBtn"><input type="button" value="비밀번호변경"></a>
            </div>
            <div class="joinContent">
                <label>닉네임</label>
                <input type="text" name="nickName" id="nickName">
            </div>
            <div class="joinContent">
                <label>이메일</label>
                <input type="text" name="email1" id="email1" placeholder="EMAIL">
                <span style="display: flex; flex-wrap: wrap; align-items: center;">@</span>
                <select name="email2" id="email2">
                    <option value="">선택</option>
                    <option value="naver.com">naver.com</option>
                    <option value="gmail.com">gmail.com</option>
                </select>
            </div>
            <div class="joinContent">
                <label>질문</label>
                <select name="question" style="margin: 0 15px;">
                    <option value="">비밀번호찾기 시 사용</option>
                    <option value="1">나의 보물 1호는 무엇인가요?</option>
                    <option value="2">어머니 성함은 무엇인가요?</option>
                    <option value="3">아버지 성함은 무엇인가요?</option>
                    <option value="4">학창시절 별명은 무엇인가요?</option>
                    <option value="5">나의 학교 이름은 무엇인가요?</option>
                </select>
            </div>
            <div class="joinContent">
                <label>답변</label>
                <input type="text" name="answer" id="answer">
            </div>
        </div>
        <div class="joinBtnWrap">
            <a><input type="button" value="회원가입"></a>
        </div>
        <div class="modifyBtnWrap">
            <a><input type="button" value="회원탈퇴" style="background: #bf3a46;"></a>
            <a><input type="button" value="변경"></a>
        </div>
    </div>

</div>