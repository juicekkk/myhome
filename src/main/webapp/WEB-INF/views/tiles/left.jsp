<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="leftWrap">
    <div class="title">MYLOGUE</div>
    <hr style="display: block; background: #987931; height: 5px; margin: 0 auto; border: navajowhite; width: 80%; border-radius: 15%;" />
    <br>

    <a href="#"><li style="margin-top: 10px;">MENU1</li></a>
    <a href="#"><li>MENU2</li></a>
    <a href="#"><li>MENU3</li></a>

    <div style="position: absolute; bottom: 0; width: 100%; height: 40px; background-color: #987931;"></div>
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
