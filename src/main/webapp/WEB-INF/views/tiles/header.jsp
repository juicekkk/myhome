<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
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

            <c:if test="${mbrNum eq null}">
                <a href="#" style="position: absolute; right: 0;" class="loginBtn"><li>LOGIN</li></a>
            </c:if>
            <c:if test="${mbrNum ne null}">
                <a href="#" style="position: absolute; right: 0;" class="logoutBtn"><li>LOGOUT</li></a>
            </c:if>


        </div>
    </div>

    <div class="for_m">
        <div class="menuWrap">
            <img class="menu_icon" src="${path}/resources/images/menu_icon.png">
            <a href="/"><li class="active">MY LOGUE</li></a>

            <c:if test="${mbrNum eq null}">
                <a href="#" class="loginBtn loginBtnImg"><img src="${path}/resources/images/loginIcon.png"></a>
            </c:if>
            <c:if test="${mbrNum ne null}">
                <a href="#" class="loginBtnImg logoutBtn" style="right: 3%;"><img src="${path}/resources/images/logoutIcon.png" style="width: 35px;"></a>
            </c:if>

        </div>
    </div>
</div>

<script type="text/javascript">
    $('.for_m .menuWrap li').click(function(){
        $('.for_m .menuWrap li').css('display', 'none');
        $(this).show();
    });

    $('.menu_icon').click(function(){
        $('#leftWrap').animate({"left": '+=350px'});
        $('#leftCloseBtn').animate({"left": '+=600px'});
        $('.darken').show();
    });

    $('.loginBtn').click(function(){
        $('.loginPopWrap').show();
        $('.darken').show();
    });

    $('.logoutBtn').click(function () {
        $.ajax({
            url:'/memberLogout.do', //request 보낼 서버의 경로
            type:'post', // 메소드(get, post, put 등)
            data:$('#loginForm').serialize(), //보낼 데이터
            dataType : 'json',
            success: function(data) {
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200 && data.result == 1){
                    alert("로그아웃 되었습니다.");
                    window.location = "/";
                }
            }, error:function(request,status,error){
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }
        });
    });

</script>
