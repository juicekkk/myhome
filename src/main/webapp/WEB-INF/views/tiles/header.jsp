<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="headerWrap">

    <div class="for_pc">
        <div class="menuWrap">
            <a href="/"><li>HOME</li></a>
            <a href="/eat.do"><li>EAT</li></a>
            <a href="/hobby.do"><li>HOBBY</li></a>
            <a href="/travel.do"><li>TRAVEL</li></a>
            <a href="/daily.do"><li>DAILY</li></a>
            <a href="/stranger.do"><li>ETC</li></a>

            <a href="#" style="position: absolute; right: 0;" class="loginBtn"><li>LOGIN</li></a>
            <a href="#" style="position: absolute; right: 0; display: none;"><li>LOGOUT</li></a>
        </div>
    </div>

    <div class="for_m">
        <div class="menuWrap">
            <img class="menu_icon" src="${path}/resources/images/menu_icon.png">
            <a href="/"><li class="active">MY LOGUE</li></a>

            <a href="#" class="loginBtn loginBtnImg"><img src="${path}/resources/images/loginIcon.png"></a>
            <a href="#" class="loginBtnImg" style="right: 3%; display: none;"><img src="${path}/resources/images/logoutIcon.png" style="width: 35px;"></a>
        </div>
    </div>
</div>

<script type="text/javascript">
    $('.for_m .menuWrap li').click(function(){
        console.log('click');
        $('.for_m .menuWrap li').css('display', 'none');
        $(this).show();
    });

    $('.menu_icon').click(function(){
        $('#leftWrap').animate({"left": '+=350px'});
        $('#leftCloseBtn').animate({"left": '+=620px'});
        $('.darken').show();
    });

    $('.loginBtn').click(function(){
        $('.loginPopWrap').show();
        $('.darken').show();
    });

</script>
