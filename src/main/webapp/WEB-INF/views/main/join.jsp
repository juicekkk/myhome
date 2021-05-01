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
        <form method="post" enctype="multipart/form-data" action="/memberReg.do">
            <div class="joinContentsWrap">
                <div class="joinContent">
                    <label>아이디</label>
                    <input type="hidden" name="idChk" value="0">
                    <input type="text" name="userId" id="userId" placeholder="ID">
                    <a href="#"><input type="button" value="중복체크" id="dupliChk" style="width: 80px;"></a>
                </div>
                <div class="joinContent">
                    <label>비밀번호</label>
                    <input type="password" name="userPwd" class="userPwd" placeholder="PASSWORD">
                </div>
                <div class="joinContent">
                    <label>비밀번호 확인</label>
                    <input type="password" class="userPwdChk" placeholder="PASSWORD CONFIRM">
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
                <a><input type="submit" value="회원가입" id="mbrRegBtn"></a>
            </div>
        </form>
    </div>

</div>

<script>
    $('#mbrRegBtn').click(function() {
       if($('#userId').val() == ''){
           alert('아이디를 입력해주세요.');
           return false;
       }

        if($('.userPwd').val() == ''){
            alert('비밀번호를 입력해주세요.');
            return false;
        }

        if($('.userPwd').val() != $('.userPwdChk').val()){
            alert('비밀번호가 일치하지 않습니다.');
            return false;
        }

        if($().val() == '0'){
            alert('아이디 중복체크를 해주세요.');
            return false;
        }

        return true;
    });

    $('#userId').keydown(function () {
        $('input[name=idChk]').val('0');
    });

    $("#dupliChk").click(function () {
        if($('#userId').val() == ''){
            alert('아이디를 입력해주세요.');
        } else {
            $.ajax({
                url:'/dupliChk.do', //request 보낼 서버의 경로
                type:'post', // 메소드(get, post, put 등)
                data:{'userId':$('#userId').val()}, //보낼 데이터
                dataType : 'json',
                success: function(data) {
                    //서버로부터 정상적으로 응답이 왔을 때 실행
                    if(data.result == 0){
                        $('input[name=idChk]').val('1');
                        alert("사용 가능한 아이디입니다.");
                    } else {
                        alert("이미 등록된 아이디입니다.");
                    }
                }, error:function(request,status,error){
                alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);}

            });

        }
    });

</script>