<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<div id="headerWrap">

    <div class="for_pc">
        <div class="menuWrap">
            <a href="#"><li>HOME_PC</li></a>
            <a href="#"><li>MENU1</li></a>
            <a href="#"><li>MENU2</li></a>
            <a href="#"><li>MENU3</li></a>
        </div>
    </div>

    <div class="for_m">
        <div class="menuWrap">
            <img class="menu_icon" src="${path}/resources/images/menu_icon.png">
            <a href="#"><li class="active">HOME_MO</li></a>
            <a href="#"><li>MENU1</li></a>
            <a href="#"><li>MENU2</li></a>
            <a href="#"><li>MENU3</li></a>
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

</script>
