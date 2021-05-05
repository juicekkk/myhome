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
    <div class="darken"></div>
    <div class="backgroundTop"></div>

    <div id="header"><tiles:insertAttribute name="header" /></div>
    <div id="left" class="for_m"><tiles:insertAttribute name="left" /></div>
    <div id="float" class="for_pc"><tiles:insertAttribute name="float" /></div>
    <div id="main"><tiles:insertAttribute name="body" /></div>
    <div id="footer"><tiles:insertAttribute name="footer" /></div>

    <div class="backgroundBottom"></div>
</div>

<form method="post" enctype="multipart/form-data" name="loginForm" id="loginForm">
    <div class="loginPopWrap">

        <div id="loginCloseBtn"><img src="${path}/resources/images/X_icon_black.png"></div>

        <span>LOGIN</span>
        <div class="loginWrap">
            <div class="login">
                <input type="text" id="userId" name="userId">
                <input type="password" id="userPwd" name="userPwd">
            </div>
            <div class="login">
                <input type="button" class="loginPopBtn" value="ENTER">
            </div>
        </div>
        <div class="loginBtnWrap">
            <a href="/find.do"><input type="button" value="아이디 | 비밀번호 찾기"></a>
            <a href="/join.do"><input type="button" value="회원가입"></a>
        </div>
    </div>
</form>

<script type="text/javascript">
    $(function() {
        $('#loginCloseBtn').click(function () {
            $('.loginPopWrap').hide();
            $('.darken').hide();
        });
    });
    $('.loginPopBtn').click(function () {
        if($('#userId').val() == ''){
            alert('아이디를 입력해주세요.');
            return false;
        }

        if($('#userPwd').val() == ''){
            alert('비밀번호를 입력해주세요.');
            return false;
        }

        $.ajax({
            url:'/memberLogin.do', //request 보낼 서버의 경로
            type:'post', // 메소드(get, post, put 등)
            data:$('#loginForm').serialize(), //보낼 데이터
            dataType : 'json',
            success: function(data) {
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200 && data.result == 1){
                    alert("로그인 되었습니다");
                    window.location = "/";
                } else {
                    alert('아이디 또는 패스워드가 일치하지 않습니다.');
                }
            }, error:function(request,status,error){
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }
        });

    });
</script>
</body>
</html>