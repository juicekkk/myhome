<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="leftWrap">
    <div class="title">MYLOGUE</div>
    <span>닉네임님 환영합니다 !</span>
    <hr style="display: block; background: #4a4a4a; height: 5px; margin: 10px auto; border: navajowhite; width: 80%; border-radius: 15%;" />
    <div class="menus">
        <span class="leftTitle">LOGUES</span>
        <a href="/stranger.do"><li style="margin-top: 10px;"> - 나의 게시판</li></a>
        <a href="/eat.do"><li>EAT</li></a>
        <a href="/hobby.do"><li>HOBBY</li></a>
        <a href="/travel.do"><li>TRAVEL</li></a>
        <a href="/daily.do"><li>DAILY</li></a>


        <a href="/stranger.do"><li style="margin-top: 10px;"> - 익명 게시판</li></a>
        <a href="/stranger.do"><li>ETC</li></a>
        <a href="/stranger.do"><li>LIKES</li></a>


        <br><br><br>
        <div>
            <span class="leftTitle">MYLOGUE</span>
            <a href="/mypage.do"><li>MY PAGE</li></a>
            <a href="/setting.do"><li>SETTING</li></a>
            <a href="/#"><li>LOGOUT</li></a>
        </div>
    </div>

    <div style="position: absolute; bottom: 0; width: 100%; height: 40px; background-color: #323232;"></div>
</div>
<div id="leftCloseBtn"><img src="${path}/resources/images/X_icon_white.png"></div>

<script type="text/javascript">

$('#leftCloseBtn').click(function(){
    $('#leftWrap').animate({"left": '-=350px'});
    $('#leftCloseBtn').animate({"left": '-=600px'});
    $('.darken').hide();
});


</script>
