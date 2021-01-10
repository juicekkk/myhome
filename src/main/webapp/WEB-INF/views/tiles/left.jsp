<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="leftWrap">
    <div class="title">MYLOGUE</div>
    <hr style="display: block; background: #4a4a4a; height: 5px; margin: 0 auto; border: navajowhite; width: 80%; border-radius: 15%;" />
    <br>

    <a href="/eat.do"><li style="margin-top: 10px;">EAT</li></a>
    <a href="/hobby.do"><li>HOBBY</li></a>
    <a href="/travel.do"><li>TRAVEL</li></a>
    <a href="/daily.do"><li>DAILY</li></a>
    <a href="/etc.do"><li>ETC</li></a>

    <div style="position: absolute; bottom: 0; width: 100%; height: 40px; background-color: #323232;"></div>
</div>
<div class="darken"></div>
<div id="leftCloseBtn"><img src="${path}/resources/images/X_icon_white.png"></div>

<script type="text/javascript">

$('#leftCloseBtn').click(function(){
    $('#leftWrap').animate({"left": '-=350px'});
    $('#leftCloseBtn').animate({"left": '-=620px'});
    $('.darken').hide();
});


</script>
