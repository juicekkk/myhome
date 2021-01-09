<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="leftWrap">
    <a href="#"><li>HOME</li></a>
    <a href="#"><li>MENU1</li></a>
    <a href="#"><li>MENU2</li></a>
    <a href="#"><li>MENU3</li></a>
</div>
<div class="darken"></div>
<div id="leftCloseBtn"><img src="${path}/resources/images/X_icon_white.png"></div>

<script type="text/javascript">

$('#leftCloseBtn').click(function(){
    $('#leftWrap').animate({"left": '-=350px'});
    $('#leftCloseBtn').animate({"left": '-=650px'});
    $('.darken').hide();
});


</script>
