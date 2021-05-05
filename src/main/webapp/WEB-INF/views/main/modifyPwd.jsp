<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<style>


</style>
<div class="boardWrap">

    <div class="titleWrap">
        <p>기록</p>
        <p>그래서 사람들은 기록한다<br>행복을 다시 꺼내보기 위해<br>행복했던 순간들을 다시 살기 위해</p>
    </div>

    <form method="post" enctype="multipart/form-data" action="/memberPwdMod.do" name="memberForm" id="memberForm">
        <div class="joinWrap">
            <div class="joinContentsWrap">
                <div class="joinContent">
                    <label>변경 전</label>
                    <input type="password" name="userPwd" class="userPwd" placeholder="CURRENT PASSWORD">
                </div>
                <div class="joinContent">
                    <label>변경 후</label>
                    <input type="password" name="newUserPwd" class="userPwd" placeholder="NEW PASSWORD">
                </div>
            </div>
            <div class="joinBtnWrap">
                <a><input type="button" value="변경" id="memberPwdModBtn"></a>
            </div>
        </div>
    </form>

</div>


<script>

    $("#memberPwdModBtn").click(function () {

        if($('.userPwd').val() == ''){
            alert('현재 비밀번호를 입력해주세요.');
            return false;
        }

        if($('.newUserPwd').val() == ''){
            alert('새 비밀번호를 입력해주세요.');
            return false;
        }

        $.ajax({
            url:'/memberPwdMod.do', //request 보낼 서버의 경로
            type:'post', // 메소드(get, post, put 등)
            data:$('#memberForm').serialize(), //보낼 데이터
            dataType : 'json',
            success: function(data) {
                //서버로부터 정상적으로 응답이 왔을 때 실행
                if(data.code == 200 && data.result == 1){
                    alert("정상적으로 처리되었습니다. 다시 로그인해주세요.");
                    window.location = "/";
                } else {
                    alert("현재 비밀번호가 일치하지 않습니다.");
                }
            }, error:function(request,status,error){
                alert('오류가 발생했습니다. 관리자에게 문의해주세요.');
            }

        });
    });

</script>